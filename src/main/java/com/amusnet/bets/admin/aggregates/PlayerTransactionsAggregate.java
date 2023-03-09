package com.amusnet.bets.admin.aggregates;

import com.amusnet.bets.admin.commands.RegisterBetCommand;
import com.amusnet.bets.admin.commands.RegisterPlayerCommand;
import com.amusnet.bets.admin.controllers.dto.RegisterBetResponseDto;
import com.amusnet.bets.admin.events.BetRegisteredEvent;
import com.amusnet.bets.admin.events.PlayerRegisteredEvent;
import com.amusnet.bets.admin.exceptions.MalformedBetException;
import com.amusnet.bets.admin.utilities.BetEngine;
import com.amusnet.bets.admin.utilities.BetOutcome;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.Map;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class PlayerTransactionsAggregate {

    @AggregateIdentifier
    private String playerId;

    @AggregateMember
    private Map<String, Transaction> transactions;
    private float balance;

    @CommandHandler
    public PlayerTransactionsAggregate(RegisterPlayerCommand command) throws MalformedBetException {
        apply(new PlayerRegisteredEvent(command.getPlayerId(), command.getInitialBalance()));
    }

    @EventSourcingHandler
    public void on(PlayerRegisteredEvent event) {
        transactions = new HashMap<>();
        this.playerId = event.getPlayerId();
        this.balance = event.getInitialBalance();
    }

    @CommandHandler
    public RegisterBetResponseDto handle(RegisterBetCommand command) throws MalformedBetException {
        if (transactions.containsKey(command.getGameActivityId())) {
            throw new MalformedBetException("transaction already registered", command.getGameActivityId());
        }
        BetOutcome outcome = BetEngine.nextBetResult();
        float balance = this.balance;
        balance -= command.getBetAmount();
        float winAmount = 0;
        if (outcome.equals(BetOutcome.WIN)) {
            winAmount = command.getBetAmount() * BetEngine.winingRate();
            balance += winAmount;
        }
        apply(new BetRegisteredEvent(
                command.getGameActivityId(),
                command.getGameId(),
                command.getPlayerId(),
                command.getBetAmount(),
                command.getCurrency(),
                outcome,
                winAmount,
                balance
        ));
        return new RegisterBetResponseDto(
                command.getGameActivityId(),
                outcome.getResult(),
                winAmount,
                command.getCurrency(),
                this.balance
        );
    }

    @EventSourcingHandler
    public void on(BetRegisteredEvent event) {
        this.balance = this.balance - event.getBetAmount() + event.getWinAmount();
        this.transactions.put(event.getGameActivityId(), new Transaction(
                event.getGameActivityId(),
                event.getGameId(),
                event.getBetAmount(),
                event.getCurrency(),
                event.getOutcome()
        ));
    }
}
