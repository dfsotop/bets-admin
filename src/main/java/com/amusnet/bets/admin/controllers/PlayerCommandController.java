package com.amusnet.bets.admin.controllers;

import com.amusnet.bets.admin.controllers.dto.RegisterPlayerDTO;
import com.amusnet.bets.admin.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerCommandController {
    private final PlayerService service;

    @PostMapping("/player")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<RegisterPlayerDTO> registerPlayer(@Valid @RequestBody RegisterPlayerDTO registerPlayerDTO) {
        return this.service.registerPlayer(registerPlayerDTO);
    }
}
