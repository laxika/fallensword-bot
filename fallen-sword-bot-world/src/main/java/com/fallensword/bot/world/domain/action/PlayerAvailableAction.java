package com.fallensword.bot.world.domain.action;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerAvailableAction implements AvailableAction {

    private int id;
    private String name;
    private int level;
    private int guildId;
}
