package com.fallensword.bot.api.endpoint.world.staticinfo.domain.response;

import com.fallensword.bot.api.domain.Result;
import com.fallensword.bot.api.endpoint.world.staticinfo.domain.response.domain.WorldTile;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorldStaticInfoResult implements Result {

    private final WorldTile[][] tiles;
}
