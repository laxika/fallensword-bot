package com.fallensword.bot.movement.target.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Location {

    private final int x;
    private final int y;
}
