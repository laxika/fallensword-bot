package com.fallensword.bot.api.domain.world.tile;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorldTile {

    private final boolean walkable;
}
