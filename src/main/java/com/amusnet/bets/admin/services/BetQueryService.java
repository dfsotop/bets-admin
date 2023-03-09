package com.amusnet.bets.admin.services;

import com.amusnet.bets.admin.model.Activity;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Service responsible for encapsulates and orchestrate the queries
 * to do over a set of Activities
 */
public interface BetQueryService {
    /**
     * Performs a query over a materialized view to return the given number of registered bets
     * @param limit total bets to show
     * @param offset total bets to skip
     * @return Set containing the requested Activities
     * @throws ExecutionException if there was an exception requesting the data
     * @throws InterruptedException if there was an exception requesting the data
     */
    List<Activity> getRegisteredBets(int limit, long offset) throws ExecutionException, InterruptedException;
}
