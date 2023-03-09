package com.amusnet.bets.admin;

import com.amusnet.bets.admin.aggregates.PlayerTransactionsAggregate;
import com.amusnet.bets.admin.commands.RegisterBetCommand;
import com.amusnet.bets.admin.commands.RegisterPlayerCommand;
import com.amusnet.bets.admin.events.PlayerRegisteredEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.axonframework.test.matchers.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BetsAdminTests {
    private FixtureConfiguration<PlayerTransactionsAggregate> fixture;

    @BeforeEach
    public void setUp() {
        fixture = new AggregateTestFixture<>(PlayerTransactionsAggregate.class);
    }

    @Test
    public void shouldRegisterNewPlayer() {
        fixture.givenNoPriorActivity()
                .when(new RegisterPlayerCommand("123", 2000))
                .expectEvents(new PlayerRegisteredEvent("123", 2000));
    }
    @Test
    public void shouldRegisterNewPlayer_AlreadyRegistered() {
        fixture.given(new PlayerRegisteredEvent("1", 2000))
                .when(new RegisterPlayerCommand("1", 1000))
                .expectExceptionMessage(Matchers.predicate(m ->((String)m).contains("Unexpected sequence number")));
    }
    @Test
    public void shouldRegisterNewBet() {
        fixture.given(new PlayerRegisteredEvent("1", 2000))
                .when(new RegisterBetCommand("1", "2", "3", 10, "EUR"))
                .expectSuccessfulHandlerExecution();
    }
}
