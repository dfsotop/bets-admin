package com.amusnet.bets.admin.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindBetsQuery {
    private int limit;
    private float offset;
}
