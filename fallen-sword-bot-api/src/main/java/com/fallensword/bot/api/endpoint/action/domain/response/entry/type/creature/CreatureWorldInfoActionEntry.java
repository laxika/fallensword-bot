package com.fallensword.bot.api.endpoint.action.domain.response.entry.type.creature;

import com.fallensword.bot.api.endpoint.action.domain.response.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CreatureWorldInfoActionEntry implements WorldInfoActionEntry {

    private final CreatureWorldInfoActionEntryData data;
}
