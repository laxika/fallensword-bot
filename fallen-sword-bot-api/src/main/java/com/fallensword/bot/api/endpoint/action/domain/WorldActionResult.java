package com.fallensword.bot.api.endpoint.action.domain;

import com.fallensword.bot.api.endpoint.action.domain.action.AvailableAction;
import com.fallensword.bot.api.domain.Result;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WorldActionResult implements Result {

    private final List<AvailableAction> availableActions;
}
