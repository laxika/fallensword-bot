package com.fallensword.bot.movement.target;

import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.location.domain.Location;
import com.fallensword.bot.world.domain.World;
import com.fallensword.bot.world.domain.tile.Tile;
import org.springframework.stereotype.Service;
import org.xguzm.pathfinding.PathFinder;
import org.xguzm.pathfinding.grid.GridCell;
import org.xguzm.pathfinding.grid.NavigationGrid;
import org.xguzm.pathfinding.grid.finders.AStarGridFinder;
import org.xguzm.pathfinding.grid.finders.GridFinderOptions;

import java.util.List;

@Service
public class MovementPathCalculator {

    public Location calculateNextTileTowards(final Location location, final Player player, final World world) {
        final GridCell[][] tiles = new GridCell[world.getWidth()][world.getHeight()];

        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                final Tile tile = world.getTileAt(x, y);

                tiles[x][y] = new GridCell(x, y, tile.isWalkable());
            }
        }

        final NavigationGrid<GridCell> navigationGrid = new NavigationGrid<>(tiles, false);

        final GridFinderOptions gridFinderOptions = new GridFinderOptions();
        gridFinderOptions.allowDiagonal = false;

        final PathFinder<GridCell> pathFinder = new AStarGridFinder<>(GridCell.class, gridFinderOptions);

        final List<GridCell> result = pathFinder.findPath(tiles[player.getLocationX()][player.getLocationY()], tiles[location.getX()][location.getY()], navigationGrid);

        return Location.builder()
                .x(result.get(0).x)
                .y(result.get(0).y)
                .build();
    }
}
