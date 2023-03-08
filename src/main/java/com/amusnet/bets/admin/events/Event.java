package com.amusnet.bets.admin.events;

import lombok.Getter;

import java.util.Date;

@Getter
public class Event implements Comparable<Event>{

    protected String playerId;

    private final Date created = new Date();

    @Override
    public int compareTo(Event e) {
        return this.created.compareTo(e.created);
    }
}
