package com.fallensword.bot.request.client.type.world.action.domain;

import com.fallensword.bot.request.client.domain.Response;
import com.fallensword.bot.request.client.type.world.action.domain.entry.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WorldActionResponse implements Response {

    private final List<WorldInfoActionEntry> actions;
}
