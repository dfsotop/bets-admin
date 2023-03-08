package com.amusnet.bets.admin.model;

import com.amusnet.bets.admin.utilities.BetOutcome;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Activity {
    @Id
    String gameActivityId;
    String gameId;
    float betAmount;
    float winAmount;
    String currency;
    Outcome outcome;
    String playerId;
    float playerBalanceAfter;
}

