package com.fallensword.bot.request.client.type.world.action.domain.entry.type.player;

import com.fallensword.bot.request.client.type.world.action.domain.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PlayerWorldInfoActionEntry implements WorldInfoActionEntry {

    private final PlayerWorldInfoActionEntryData data;
}
