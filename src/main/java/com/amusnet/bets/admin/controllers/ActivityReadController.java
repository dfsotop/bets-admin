package com.amusnet.bets.admin.controllers;

import com.amusnet.bets.admin.model.Activity;
import com.amusnet.bets.admin.services.BetQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/bets")
@RequiredArgsConstructor
public class ActivityReadController {

    private final BetQueryService service;
    @GetMapping("/")
    public List<Activity> getBets(@RequestParam int limit, @RequestParam long offset) throws ExecutionException, InterruptedException {
        return service.getRegisteredBets(limit, offset);
    }
}
