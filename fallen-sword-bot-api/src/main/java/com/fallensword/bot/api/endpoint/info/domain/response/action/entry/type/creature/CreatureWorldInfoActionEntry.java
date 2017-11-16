package com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.creature;

import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CreatureWorldInfoActionEntry implements WorldInfoActionEntry {

    private final CreatureWorldInfoActionEntryData data;
}
