package com.fallensword.bot.api.endpoint.action.domain.response;

import com.fallensword.bot.api.endpoint.action.domain.response.entry.WorldInfoActionEntry;
import lombok.Getter;

import java.util.List;

@Getter
public class WorldActionResponse {

    private List<WorldInfoActionEntry> actions;
}
