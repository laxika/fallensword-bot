package com.fallensword.bot.request.client.type.world.action.domain.entry.type.creature;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CreatureWorldInfoActionEntryData {

    private final int id;
    private final String ac;
    private final String name;
    private final int level;
}
