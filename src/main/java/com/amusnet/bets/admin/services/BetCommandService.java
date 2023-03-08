package com.amusnet.bets.admin.services;

import com.amusnet.bets.admin.controllers.dto.RegisterBetResponseDto;
import com.amusnet.bets.admin.controllers.dto.NewBetDTO;

import java.util.concurrent.CompletableFuture;

public interface BetCommandService {
    RegisterBetResponseDto registerBet(NewBetDTO commandRequestDto);
}
