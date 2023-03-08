package com.amusnet.bets.admin.controllers.dto;

import lombok.Data;

@Data
public class RegisterPlayerDTO {
    private String playerId;
    private float initialBalance;
}
