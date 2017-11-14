package com.fallensword.bot.request.client.type.world.staticinfo.domain.response.raw;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RawWorldStaticInfoResponse {

    private final RawWorldStaticInfoEntry realm;
}
