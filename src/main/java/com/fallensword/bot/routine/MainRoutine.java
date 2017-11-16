package com.fallensword.bot.routine;

import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.domain.world.World;
import com.fallensword.bot.api.domain.world.action.CreatureAvailableAction;
import com.fallensword.bot.api.domain.world.tile.WorldTile;
import com.fallensword.bot.api.endpoint.attack.AttackEndpoint;
import com.fallensword.bot.api.endpoint.attack.domain.AttackContext;
import com.fallensword.bot.api.endpoint.attack.domain.TargetCreature;
import com.fallensword.bot.api.endpoint.info.FetchInfoEndpoint;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoContext;
import com.fallensword.bot.api.endpoint.movement.MovementEndpoint;
import com.fallensword.bot.api.endpoint.movement.domain.MovementContext;
import com.fallensword.bot.routine.context.domain.RoutineContext;
import com.fallensword.bot.routine.movement.domain.MovementTarget;
import com.fallensword.bot.routine.wait.WaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainRoutine {

    private final AttackEndpoint attackEndpoint;
    private final MovementEndpoint movementEndpoint;
    private final WaitingService waitingService;
    private final FetchInfoEndpoint fetchInfoEndpoint;

    //Very VERY dumb test AI
    public void startBotRoutine(final RoutineContext routineContext) {
        final Player player = routineContext.getPlayer();
        final World world = routineContext.getWorld();

        while (true) {
            //Fetch available actions
            fetchInfoEndpoint.request(
                    FetchInfoContext.builder()
                            .player(player)
                            .world(world)
                            .flags(
                                    EnumSet.of(
                                            FetchFlag.PLAYER_INFO,
                                            FetchFlag.AVAILABLE_ACTIONS
                                    )
                            )
                            .build()
            );

            waitingService.randomWait(2000);

            //Fight all the killable monsters
            world.getAvailableActions().stream()
                    .filter(worldInfoActionEntry -> worldInfoActionEntry instanceof CreatureAvailableAction)
                    .forEach(worldInfoActionEntry -> {
                        final CreatureAvailableAction creatureAvailableAction =
                                (CreatureAvailableAction) worldInfoActionEntry;

                        attackEndpoint.request(
                                AttackContext.builder()
                                        .creature(
                                                TargetCreature.builder()
                                                        .id(creatureAvailableAction.getId())
                                                        .ac(creatureAvailableAction.getAc())
                                                        .name(creatureAvailableAction.getName())
                                                        .level(creatureAvailableAction.getLevel())
                                                        .build()
                                        )
                                        .build()
                        );

                        waitingService.randomWait(2000);
                    });

            //If we had the maximum available actions on the map we refresh because maybe we will have more monsters to kill
            if (world.getAvailableActions().size() >= 8) {
                continue;
            }

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
    }

    private int calculateMovementCountForTarget(final World world, final int x, final int y) {
        final WorldTile tile = world.getTileAt(x, y);

        return tile != null && tile.isWalkable() ? tile.getMovementCount() : -1;
    }
}
