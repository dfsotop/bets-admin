package com.amusnet.bets.admin.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisteredBetsQuery {
    int limit;
    long offset;
}
