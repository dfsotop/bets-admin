package com.amusnet.bets.admin.utilities;

import java.util.Random;

public class BetEngine {
    private static final Random random = new Random();
    public static BetOutcome nextBetResult() {
        return random.nextBoolean() ? BetOutcome.WIN : BetOutcome.LOSE;
    }

    public static float winingRate() {
        return 1.69f;
    }
}

