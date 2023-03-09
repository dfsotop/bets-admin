package com.amusnet.bets.admin.events;

import com.amusnet.bets.admin.utilities.BetOutcome;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
public class BetRegisteredEvent {

    private final String playerId;
    private final String gameActivityId;
    private final String gameId;
    private final float betAmount;
    private final String currency;
    private final BetOutcome outcome;
    private final float winAmount;
    private final float balanceAfter;

}


