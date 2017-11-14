package com.fallensword.bot.request.client.type.world.staticinfo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorldStaticInfoEntry {

    private final String block;
}
