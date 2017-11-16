package com.fallensword.bot.api.domain.world.tile;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorldTile {

    @Setter
    private int movementCount;

    private final boolean walkable;
}
