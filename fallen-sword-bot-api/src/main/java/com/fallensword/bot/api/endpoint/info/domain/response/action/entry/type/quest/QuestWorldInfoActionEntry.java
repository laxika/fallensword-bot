package com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.quest;

import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class QuestWorldInfoActionEntry implements WorldInfoActionEntry {

    private final QuestWorldInfoActionEntryData data;
}
