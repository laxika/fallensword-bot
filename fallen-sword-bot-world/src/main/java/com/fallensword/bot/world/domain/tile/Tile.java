package com.fallensword.bot.world.domain.tile;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Tile {

    @Setter
    private int movementCount;

    private final boolean walkable;
}
