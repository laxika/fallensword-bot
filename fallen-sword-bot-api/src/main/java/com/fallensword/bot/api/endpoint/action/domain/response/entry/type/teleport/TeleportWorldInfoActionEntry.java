package com.fallensword.bot.api.endpoint.action.domain.response.entry.type.teleport;

import com.fallensword.bot.api.endpoint.action.domain.response.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TeleportWorldInfoActionEntry implements WorldInfoActionEntry {

    private final TeleportWorldInfoActionEntryData data;
}
