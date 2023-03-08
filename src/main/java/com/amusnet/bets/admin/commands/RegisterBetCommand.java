package com.amusnet.bets.admin.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBetCommand {

    @TargetAggregateIdentifier
    String playerId;

    String gameActivityId;
    String gameId;
    float betAmount;
    String currency;
}
