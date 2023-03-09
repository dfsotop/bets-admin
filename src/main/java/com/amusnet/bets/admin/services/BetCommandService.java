package com.amusnet.bets.admin.services;

import com.amusnet.bets.admin.controllers.dto.NewBetDTO;
import com.amusnet.bets.admin.controllers.dto.RegisterBetResponseDto;

/**
 * Service responsible for register the intended changes over a Bet
 * requested for a Player
 */
public interface BetCommandService {

    /**
     * register the intention of insert a new bet into the system
     * @param commandRequestDto the intention of a bet to register in the system
     * @return The corresponding response if the intention was successfully handled
     */
    RegisterBetResponseDto registerBet(NewBetDTO commandRequestDto);
}
