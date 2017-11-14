package com.fallensword.bot.request.client.type.world.staticinfo.domain.response.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorldTile {

    private final boolean walkable;
}
