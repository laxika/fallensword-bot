package com.fallensword.bot.api.domain.world;

import com.fallensword.bot.api.domain.world.action.AvailableAction;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class World {

    private List<AvailableAction> availableActions;
}
