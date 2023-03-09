package com.amusnet.bets.admin.services.impl;

import com.amusnet.bets.admin.commands.RegisterPlayerCommand;
import com.amusnet.bets.admin.controllers.dto.RegisterPlayerDTO;
import com.amusnet.bets.admin.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Implementation of the contract PlayerService.
 * This service uses the axon framework's commandGateway
 * to propagate Player related events
 */
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<RegisterPlayerDTO> registerPlayer(RegisterPlayerDTO dto) {
        return commandGateway.send(new RegisterPlayerCommand(dto.getPlayerId(), dto.getInitialBalance()));
    }
}
