package com.fallensword.bot.request.client.type.world.staticinfo.domain.response;

import com.fallensword.bot.request.client.domain.Response;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.response.domain.WorldTile;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorldStaticInfoResponse implements Response {

    private final WorldTile[][] tiles;
}
