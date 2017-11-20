package com.fallensword.bot.api.domain.world;

import com.fallensword.bot.api.domain.world.action.AvailableAction;
import com.fallensword.bot.api.domain.world.dynamic.DynamicEntry;
import com.fallensword.bot.api.domain.world.tile.WorldTile;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Builder
public class World {

    @Getter
    private List<AvailableAction> availableActions;

    @Getter
    private int width;

    @Getter
    private int height;

    @Getter
    private List<DynamicEntry> dynamicEntries;

    private WorldTile[][] tiles;

    public WorldTile getTileAt(final int x, final int y) {
        if (x < 0 || y < 0 || x > width || y > height) {
            return null;
        }

        return tiles[y][x];
    }
}
