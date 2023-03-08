package com.amusnet.bets.admin.controllers.dto;

import lombok.Data;

@Data
public class NewBetDTO {
    String gameActivityId;
    String gameId;
    String playerId;
    float betAmount;
    String currency;
}