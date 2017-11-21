package com.fallensword.bot.movement.target;

import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.location.domain.Location;
import com.fallensword.bot.movement.target.domain.MovementTarget;
import com.fallensword.bot.world.domain.World;
import com.fallensword.bot.world.domain.tile.Tile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculate the next tile to move to for the player on the map. The target is either one tile east/west/north/south
 * from where the player is standing on. The calculation works in a way that tries to minimize the movement to the same
 * tiles that the player already visited. This way the player will always explore new tiles (where usually more
 * monsters available).
 */
@Service
public class MovementTargetCalculator {

    public Location calculateNextTarget(final Player player, final World world) {
        final Map<MovementTarget, Integer> targetMap = new HashMap<>();

        targetMap.put(MovementTarget.NORTH, calculateMovementCountForTarget(world, player.getLocationX(), player.getLocationY() - 1));
        targetMap.put(MovementTarget.SOUTH, calculateMovementCountForTarget(world, player.getLocationX(), player.getLocationY() + 1));
        targetMap.put(MovementTarget.WEST, calculateMovementCountForTarget(world, player.getLocationX() - 1, player.getLocationY()));
        targetMap.put(MovementTarget.EAST, calculateMovementCountForTarget(world, player.getLocationX() + 1, player.getLocationY()));

        int lowestMovementCount = Integer.MAX_VALUE;
        MovementTarget target = null;
        for (Map.Entry<MovementTarget, Integer> entry : targetMap.entrySet()) {
            if (entry.getValue() != -1 && lowestMovementCount > entry.getValue()) {
                lowestMovementCount = entry.getValue();
                target = entry.getKey();
            }
        }

        if (target == null) {
            throw new IllegalStateException("No target found for moving!");
        }

        int targetX = -1;
        int targetY = -1;
        switch (target) {
            case NORTH:
                targetX = player.getLocationX();
                targetY = player.getLocationY() - 1;
                break;
            case SOUTH:
                targetX = player.getLocationX();
                targetY = player.getLocationY() + 1;
                break;
            case WEST:
                targetX = player.getLocationX() - 1;
                targetY = player.getLocationY();
                break;
            case EAST:
                targetX = player.getLocationX() + 1;
                targetY = player.getLocationY();
                break;
        }

        if (targetX == -1 || targetY == -1) {
            throw new IllegalStateException("Target coordinates are wrong!");
        }

        return Location.builder()
                .x(targetX)
                .y(targetY)
                .build();
    }

    private int calculateMovementCountForTarget(final World world, final int x, final int y) {
        final Tile tile = world.getTileAt(x, y);

        return tile != null && tile.isWalkable() ? tile.getMovementCount() : -1;
    }
}
