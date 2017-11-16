package com.fallensword.bot.api.endpoint.info.domain.response.world;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RawWorldStaticInfoPartialResponse {

    private final RealmPartialResponse realm;
}
