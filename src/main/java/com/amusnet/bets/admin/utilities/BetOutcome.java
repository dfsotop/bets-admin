package com.amusnet.bets.admin.utilities;

import lombok.Getter;

public enum BetOutcome {
    WIN("WIN"),
    LOSE("LOSE");
    @Getter
    private final String result;

    BetOutcome(String result) {
        this.result = result;
    }
}
