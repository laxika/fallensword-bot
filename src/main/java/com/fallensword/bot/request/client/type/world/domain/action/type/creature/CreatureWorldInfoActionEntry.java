package com.fallensword.bot.request.client.type.world.domain.action.type.creature;

import com.fallensword.bot.request.client.type.world.domain.action.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CreatureWorldInfoActionEntry implements WorldInfoActionEntry {

    private final CreatureWorldInfoActionEntryData data;
}
