package com.amusnet.bets.admin.projection;

import com.amusnet.bets.admin.events.BetRegisteredEvent;
import com.amusnet.bets.admin.exceptions.MalformedBetException;
import com.amusnet.bets.admin.model.Activity;
import com.amusnet.bets.admin.model.Outcome;
import com.amusnet.bets.admin.queries.RegisteredBetsQuery;
import com.amusnet.bets.admin.repositores.EventRepository;
import com.amusnet.bets.admin.repositores.OffsetLimitRequest;
import com.amusnet.bets.admin.utilities.BetOutcome;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class BetProjection {
    private final EventRepository repository;

    @EventHandler
    public void on(BetRegisteredEvent event) throws MalformedBetException {
        log.debug("Handling registered bet command {}", event.getGameActivityId());
        if (repository.findById(event.getGameActivityId()).isPresent()){
            throw new MalformedBetException("activity already registered", event.getGameActivityId());
        }
        Activity activity = new Activity(
                event.getGameActivityId(),
                event.getGameId(),
                event.getBetAmount(),
                event.getWinAmount(),
                event.getCurrency(),
                Outcome.valueOf(event.getOutcome().name()),
                event.getPlayerId(),
                event.getBalanceAfter()
        );
        this.repository.save(activity);
    }

    @QueryHandler
    public List<Activity> getRegisteredBets(RegisteredBetsQuery query) {
        log.debug("Handling get Registered bets");
        OffsetLimitRequest pageable = new OffsetLimitRequest(query.getLimit(), query.getOffset());
        Page<Activity> pagedActivities = repository.findAll(pageable);
        return pagedActivities.getContent();
    }
}
