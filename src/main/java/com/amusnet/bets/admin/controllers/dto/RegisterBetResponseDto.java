package com.amusnet.bets.admin.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterBetResponseDto {
    String gameActivityId;
    String outcome;
    float winAmount;
    String currency;
    float playerBalanceAfter;
}
