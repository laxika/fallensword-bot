package com.fallensword.bot.api.endpoint.quest.domain;

import com.fallensword.bot.api.domain.Context;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class QuestContext implements Context {

    private final int questId;
}
