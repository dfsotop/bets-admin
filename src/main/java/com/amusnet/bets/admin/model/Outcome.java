package com.amusnet.bets.admin.model;

import lombok.Getter;

@Getter
public enum Outcome {
    WIN("WIN"),
    LOSE("LOSE");

    private final String value;

    Outcome(String value) {
        this.value = value;
    }
}
