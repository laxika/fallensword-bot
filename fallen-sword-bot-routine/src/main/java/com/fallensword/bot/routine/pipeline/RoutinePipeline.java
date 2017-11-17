package com.fallensword.bot.routine.pipeline;

import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import com.fallensword.bot.routine.pipeline.handler.RoutineHandler;

import java.util.List;

public class RoutinePipeline {

    private final List<RoutineHandler> routineHandlers;

    public RoutinePipeline(final List<RoutineHandler> routineHandlers) {
        this.routineHandlers = routineHandlers;
    }

    public void proceedWithRoutine(final RoutineContext routineContext) {
        final int nextRouteHandlerId = routineContext.getNextRoutineHandlerId();

        if (routineHandlers.get(nextRouteHandlerId) != null) {
            routineHandlers.get(nextRouteHandlerId).handle(
                    RoutineContext.builder()
                            .nextRoutineHandlerId(nextRouteHandlerId + 1)
                            .player(routineContext.getPlayer())
                            .world(routineContext.getWorld())
                            .build(),
                    this
            );
        }
    }
}
