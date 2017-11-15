package com.fallensword.bot.api.endpoint.attack.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TargetCreature {

    private final int id;
    private final String ac;
    private final String name;
    private final int level;
}
