package com.fallensword.bot.request.client.type.world.domain;

import com.fallensword.bot.request.client.Response;
import com.fallensword.bot.request.client.type.world.domain.action.WorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WorldInfoResponse implements Response {

    private final List<WorldInfoActionEntry> actions;
}
