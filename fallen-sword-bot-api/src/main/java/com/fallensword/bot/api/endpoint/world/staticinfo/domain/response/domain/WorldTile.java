package com.fallensword.bot.api.endpoint.world.staticinfo.domain.response.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorldTile {

    private final boolean walkable;
}
