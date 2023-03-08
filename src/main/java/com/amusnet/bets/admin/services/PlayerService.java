package com.amusnet.bets.admin.services;

import com.amusnet.bets.admin.commands.RegisterPlayerCommand;
import com.amusnet.bets.admin.controllers.dto.RegisterPlayerDTO;

import java.util.concurrent.CompletableFuture;

public interface PlayerService {
    CompletableFuture<RegisterPlayerDTO> registerPlayer(RegisterPlayerDTO registerPlayerDTO);
}
