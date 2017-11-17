package com.fallensword.bot.routine.pipeline.handler.impl;

import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.domain.world.World;
import com.fallensword.bot.api.domain.world.tile.WorldTile;
import com.fallensword.bot.api.endpoint.movement.MovementEndpoint;
import com.fallensword.bot.api.endpoint.movement.domain.MovementContext;
import com.fallensword.bot.routine.movement.domain.MovementTarget;
import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import com.fallensword.bot.routine.pipeline.handler.RoutineHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * This {@link RoutineHandler} will let the player move on the map. The movement is somewhat random but the player
 * will try to explore tiles that he had not explored before to maximize the number of monsters that can be killed.
 */
@Service
@RequiredArgsConstructor
public class MoveRoutineHandler implements RoutineHandler {

    private final MovementEndpoint movementEndpoint;

    @Override
    public void handle(RoutineContext routineContext, RoutinePipeline routinePipeline) {
        final Player player = routineContext.getPlayer();
        final World world = routineContext.getWorld();

        //Move
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

        final WorldTile targetTile = world.getTileAt(targetX, targetY);
        targetTile.setMovementCount(targetTile.getMovementCount() + 1);

        movementEndpoint.request(
                MovementContext.builder()
                        .player(player)
                        .targetX(targetX)
                        .targetY(targetY)
                        .build()
        );
    }

    private int calculateMovementCountForTarget(final World world, final int x, final int y) {
        final WorldTile tile = world.getTileAt(x, y);

        return tile != null && tile.isWalkable() ? tile.getMovementCount() : -1;
    }
}
