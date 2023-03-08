package com.amusnet.bets.admin.services.impl;

import com.amusnet.bets.admin.commands.RegisterBetCommand;
import com.amusnet.bets.admin.controllers.dto.NewBetDTO;
import com.amusnet.bets.admin.controllers.dto.RegisterBetResponseDto;
import com.amusnet.bets.admin.services.BetCommandService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetCommandServiceImpl implements BetCommandService {

    private final CommandGateway commandGateway;
    @Override
    public RegisterBetResponseDto registerBet(NewBetDTO requestDto) {
        return commandGateway.sendAndWait(new RegisterBetCommand(
                requestDto.getPlayerId(),
                requestDto.getGameActivityId(),
                requestDto.getGameId(),
                requestDto.getBetAmount(),
                requestDto.getCurrency()
        ));
    }
}
