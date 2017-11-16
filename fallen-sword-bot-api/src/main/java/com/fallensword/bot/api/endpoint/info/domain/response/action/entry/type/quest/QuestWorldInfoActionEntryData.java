package com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.quest;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class QuestWorldInfoActionEntryData {

    private final int id;
    private final String name;
    private final int stage;
}
