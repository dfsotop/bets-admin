package com.amusnet.bets.admin.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPlayerCommand {
    @TargetAggregateIdentifier
    private String playerId;
    private float initialBalance;
}
