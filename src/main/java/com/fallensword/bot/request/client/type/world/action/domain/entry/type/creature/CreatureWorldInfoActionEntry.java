package com.fallensword.bot.request.client.type.world.action.domain.entry.type.creature;

import com.fallensword.bot.request.client.type.world.action.domain.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CreatureWorldInfoActionEntry implements WorldInfoActionEntry {

    private final CreatureWorldInfoActionEntryData data;
}
