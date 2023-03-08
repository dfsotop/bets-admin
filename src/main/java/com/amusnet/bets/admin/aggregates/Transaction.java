package com.amusnet.bets.admin.aggregates;

import com.amusnet.bets.admin.utilities.BetOutcome;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.EntityId;

@Data
@AllArgsConstructor
public class Transaction {
    @EntityId
    private String gameActivityId;
    private String gameId;
    private float betAmount;
    private String currency;
    private BetOutcome outcome;
}
