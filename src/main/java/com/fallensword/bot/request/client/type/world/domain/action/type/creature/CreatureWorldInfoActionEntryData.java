package com.fallensword.bot.request.client.type.world.domain.action.type.creature;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CreatureWorldInfoActionEntryData {

    private final int id;
    private final String name;
    private final int level;
}
