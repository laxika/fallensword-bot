package com.fallensword.bot.routine.pipeline.handler.impl;

import com.fallensword.bot.movement.MovementFacade;
import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import com.fallensword.bot.routine.pipeline.handler.RoutineHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This {@link RoutineHandler} will let the player move on the map. The movement is somewhat random but the player
 * will try to explore tiles that he had not explored before to maximize the number of monsters that can be killed.
 */
@Service
@RequiredArgsConstructor
public class MoveRoutineHandler implements RoutineHandler {

    private final MovementFacade movementFacade;

    @Override
    public void handle(RoutineContext routineContext, RoutinePipeline routinePipeline) {
        movementFacade.moveToRandomAdjacentTile(routineContext.getPlayer(), routineContext.getWorld());
    }
}
