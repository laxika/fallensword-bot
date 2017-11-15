package com.fallensword.bot.api.endpoint.action.domain.action;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreatureAvailableAction implements AvailableAction {

    private final int id;
    private final String ac;
    private final String name;
    private final int level;
}
