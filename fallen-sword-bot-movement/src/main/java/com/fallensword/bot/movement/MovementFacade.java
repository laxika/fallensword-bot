package com.fallensword.bot.movement;

import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.domain.world.World;
import com.fallensword.bot.api.domain.world.tile.WorldTile;
import com.fallensword.bot.api.endpoint.movement.MovementEndpoint;
import com.fallensword.bot.api.endpoint.movement.domain.MovementContext;
import com.fallensword.bot.movement.target.MovementPathCalculator;
import com.fallensword.bot.movement.target.MovementTargetCalculator;
import com.fallensword.bot.location.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Provides an easy access point for the movement services.
 */
@Service
@RequiredArgsConstructor
public class MovementFacade {

    private final MovementEndpoint movementEndpoint;
    private final MovementTargetCalculator movementTargetCalculator;
    private final MovementPathCalculator movementPathCalculator;

    /**
     * Move one tile towards a given location on the map.
     *
     * @param location the location to move towards to
     * @param player the player to move
     * @param world the world of the player
     */
    public void moveTowardsTile(final Location location, final Player player, final World world) {
        final Location targetAdjacentTile = movementPathCalculator.calculateNextTileTowards(location, player, world);

        moveToAdjacentTile(targetAdjacentTile, player, world);
    }

    /**
     * Move to a semi-randomly chosen adjacent tile. The player going to move to one of the adjacent tiles randomly
     * chosen from the least moved adjacent tiles.
     *
     * @param player the player to move
     * @param world the world of the player
     */
    public void moveToRandomAdjacentTile(final Player player, final World world) {
        final Location location = movementTargetCalculator.calculateNextTarget(player, world);

        moveToAdjacentTile(location, player, world);
    }

    /**
     * Move the player to the adjacent location. The location should be adjacent to the player's actual location.
     *
     * @param location the location to move to
     * @param player the player to move
     * @param world the world of the player
     */
    public void moveToAdjacentTile(final Location location, final Player player, final World world) {
        final WorldTile targetTile = world.getTileAt(location.getX(), location.getY());
        targetTile.setMovementCount(targetTile.getMovementCount() + 1);

        movementEndpoint.request(
                MovementContext.builder()
                        .player(player)
                        .targetX(location.getX())
                        .targetY(location.getY())
                        .build()
        );
    }
}
