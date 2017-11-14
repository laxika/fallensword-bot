package com.fallensword.bot.request.client.type.world.action.domain.entry.type.teleport;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TeleportWorldInfoActionEntryData {

    private final int id;
    private final String name;
}
