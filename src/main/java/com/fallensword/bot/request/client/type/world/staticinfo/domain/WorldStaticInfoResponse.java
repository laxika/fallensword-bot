package com.fallensword.bot.request.client.type.world.staticinfo.domain;

import com.fallensword.bot.request.client.Response;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorldStaticInfoResponse implements Response {

    private final WorldStaticInfoEntry realm;
}
