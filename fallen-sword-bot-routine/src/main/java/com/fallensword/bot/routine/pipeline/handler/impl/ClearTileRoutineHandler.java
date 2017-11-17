package com.fallensword.bot.routine.pipeline.handler.impl;

import com.fallensword.bot.api.domain.world.action.CreatureAvailableAction;
import com.fallensword.bot.api.endpoint.attack.AttackEndpoint;
import com.fallensword.bot.api.endpoint.attack.domain.AttackContext;
import com.fallensword.bot.api.endpoint.attack.domain.TargetCreature;
import com.fallensword.bot.routine.WaitingService;
import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import com.fallensword.bot.routine.pipeline.handler.RoutineHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This {@link RoutineHandler} will kill every monster on the tile the player is standing on.
 */
@Service
@RequiredArgsConstructor
public class ClearTileRoutineHandler implements RoutineHandler {

    private final AttackEndpoint attackEndpoint;
    private final WaitingService waitingService;

    @Override
    public void handle(RoutineContext routineContext, RoutinePipeline routinePipeline) {
        routineContext.getWorld().getAvailableActions().stream()
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

        /*
         * If we had the maximum available actions on the map we don't proceed and rather refresh because maybe we
         * will have more monsters to kill on this tile.
         */
        if (routineContext.getWorld().getAvailableActions().size() != 8) {
            routinePipeline.proceedWithRoutine(routineContext);
        }
    }
}
