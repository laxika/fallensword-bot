package com.fallensword.bot.api.endpoint.info.domain.response.action;

import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.WorldInfoActionEntry;
import lombok.Getter;

import java.util.List;

@Getter
public class WorldActionResponse {

    private List<WorldInfoActionEntry> actions;
}
