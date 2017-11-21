package com.fallensword.bot.world.domain;

import com.fallensword.bot.world.domain.action.AvailableAction;
import com.fallensword.bot.world.domain.dynamic.DynamicEntry;
import com.fallensword.bot.world.domain.tile.Tile;
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

    private Tile[][] tiles;

    public Tile getTileAt(final int x, final int y) {
        if (x < 0 || y < 0 || x > width || y > height) {
            return null;
        }

        return tiles[y][x];
    }
}
