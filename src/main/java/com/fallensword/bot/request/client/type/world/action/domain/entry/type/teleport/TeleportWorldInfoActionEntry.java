package com.fallensword.bot.request.client.type.world.action.domain.entry.type.teleport;

import com.fallensword.bot.request.client.type.world.action.domain.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TeleportWorldInfoActionEntry implements WorldInfoActionEntry {

    private final TeleportWorldInfoActionEntryData data;
}
