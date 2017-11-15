package com.fallensword.bot.api.endpoint.action.domain.response.entry.type.player;

import com.fallensword.bot.api.endpoint.action.domain.response.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PlayerWorldInfoActionEntry implements WorldInfoActionEntry {

    private final PlayerWorldInfoActionEntryData data;
}
