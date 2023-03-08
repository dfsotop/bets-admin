package com.amusnet.bets.admin.events;

import lombok.Getter;

@Getter
public class PlayerRegisteredEvent extends Event {
    private final float initialBalance;
    public PlayerRegisteredEvent(String playerId, float initialBalance) {
        this.playerId = playerId;
        this.initialBalance = initialBalance;
    }
}
