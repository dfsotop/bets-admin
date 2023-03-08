package com.amusnet.bets.admin.services.impl;

import com.amusnet.bets.admin.model.Activity;
import com.amusnet.bets.admin.queries.RegisteredBetsQuery;
import com.amusnet.bets.admin.repositores.EventRepository;
import com.amusnet.bets.admin.repositores.OffsetLimitRequest;
import com.amusnet.bets.admin.services.BetQueryService;
import lombok.AllArgsConstructor;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class BetQueryServiceImpl implements BetQueryService {
    private final QueryGateway queryGateway;
    @Override
    public List<Activity> getRegisteredBets(int limit, long offset) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Activity>> rs = this.queryGateway.query(
                new RegisteredBetsQuery(limit, offset),
                ResponseTypes.multipleInstancesOf(Activity.class)
        );
        return rs.get();
    }
}
