package com.amusnet.bets.admin.controllers;

import com.amusnet.bets.admin.controllers.dto.RegisterBetResponseDto;
import com.amusnet.bets.admin.controllers.dto.NewBetDTO;
import com.amusnet.bets.admin.services.BetCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/bets")
@RequiredArgsConstructor
public class BetCommandController {

    private final BetCommandService service;
    @PostMapping("/bet")
    @ResponseStatus(value = HttpStatus.CREATED)
        public RegisterBetResponseDto registerBet(@Valid @RequestBody NewBetDTO newBetDTO) {
        return this.service.registerBet(newBetDTO);
    }
}
