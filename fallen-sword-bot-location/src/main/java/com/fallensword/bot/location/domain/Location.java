package com.fallensword.bot.location.domain;

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
