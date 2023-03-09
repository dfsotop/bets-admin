package com.amusnet.bets.admin.services;

import com.amusnet.bets.admin.controllers.dto.RegisterPlayerDTO;

import java.util.concurrent.CompletableFuture;

/**
 * Contract responsible for defining the Command intentions related with a Player
 */
public interface PlayerService {

    /**
     * Registers a player into the Database
     * @param registerPlayerDTO given player into the Database
     * @return The RegisteredPlayer response, once it has been done
     */
    CompletableFuture<RegisterPlayerDTO> registerPlayer(RegisterPlayerDTO registerPlayerDTO);
}
