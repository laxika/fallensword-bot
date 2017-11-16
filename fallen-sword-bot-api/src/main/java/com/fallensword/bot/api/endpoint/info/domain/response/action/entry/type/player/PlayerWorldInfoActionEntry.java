package com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.player;

import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PlayerWorldInfoActionEntry implements WorldInfoActionEntry {

    private final PlayerWorldInfoActionEntryData data;
}
