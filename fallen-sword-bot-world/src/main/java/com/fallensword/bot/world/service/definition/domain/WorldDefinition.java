package com.fallensword.bot.world.service.definition.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WorldDefinition {

    private final int id;
    private final String name;
    private final int minimumLevel;
    private final int maximumLevel;
}
