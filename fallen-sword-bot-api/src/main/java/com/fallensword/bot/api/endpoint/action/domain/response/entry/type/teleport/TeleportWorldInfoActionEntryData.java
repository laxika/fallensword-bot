package com.fallensword.bot.api.endpoint.action.domain.response.entry.type.teleport;

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
