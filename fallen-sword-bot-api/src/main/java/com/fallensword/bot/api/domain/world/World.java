package com.fallensword.bot.api.domain.world;

import com.fallensword.bot.api.domain.world.action.AvailableAction;
import com.fallensword.bot.api.domain.world.tile.WorldTile;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class World {

    private List<AvailableAction> availableActions;

    private int width;
    private int height;
    private WorldTile[][] tiles;
}
