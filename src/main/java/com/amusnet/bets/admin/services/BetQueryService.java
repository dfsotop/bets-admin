package com.amusnet.bets.admin.services;

import com.amusnet.bets.admin.model.Activity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface BetQueryService {
    List<Activity> getRegisteredBets(int limit, long offset) throws ExecutionException, InterruptedException;
}
