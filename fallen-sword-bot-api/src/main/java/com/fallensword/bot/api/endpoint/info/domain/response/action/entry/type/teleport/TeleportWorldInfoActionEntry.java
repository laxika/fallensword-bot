package com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.teleport;

import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TeleportWorldInfoActionEntry implements WorldInfoActionEntry {

    private final TeleportWorldInfoActionEntryData data;
}
