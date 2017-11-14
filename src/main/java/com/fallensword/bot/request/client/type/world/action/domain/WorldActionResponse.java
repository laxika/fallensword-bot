package com.fallensword.bot.request.client.type.world.action.domain;

import com.fallensword.bot.request.client.domain.Response;
import com.fallensword.bot.request.client.type.world.action.domain.entry.WorldInfoActionEntry;
import lombok.Getter;

import java.util.List;

@Getter
public class WorldActionResponse implements Response {

    private List<WorldInfoActionEntry> actions;
}
