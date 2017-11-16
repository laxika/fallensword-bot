package com.fallensword.bot.api.domain.world.action;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeleportAvailableAction implements AvailableAction {

    private final int id;
    private final String name;
}
