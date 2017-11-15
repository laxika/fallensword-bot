package com.fallensword.bot.api.endpoint.action.domain.action;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeleportAvailableAction implements AvailableAction {

    private final int id;
    private final String name;
}
