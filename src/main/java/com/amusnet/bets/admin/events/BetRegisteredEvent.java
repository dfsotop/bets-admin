package com.amusnet.bets.admin.events;

import com.amusnet.bets.admin.utilities.BetOutcome;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
public class BetRegisteredEvent extends Event {

    private final String gameActivityId;
    private final String gameId;
    private final float betAmount;
    private final String currency;
    private final BetOutcome outcome;
    private final float winAmount;
    private final float balanceAfter;

    public BetRegisteredEvent(String gameActivityId, String gameId, String playerId, float betAmount, String currency, BetOutcome outcome, float winAmount, float balanceAfter) {
        this.gameActivityId = gameActivityId;
        this.gameId = gameId;
        this.playerId = playerId;
        this.betAmount = betAmount;
        this.currency = currency;
        this.outcome = outcome;
        this.winAmount = winAmount;
        this.balanceAfter = balanceAfter;
    }
}


