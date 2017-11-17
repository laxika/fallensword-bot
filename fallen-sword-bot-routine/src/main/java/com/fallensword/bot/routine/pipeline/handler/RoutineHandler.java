package com.fallensword.bot.routine.pipeline.handler;

import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;

public interface RoutineHandler {

    void handle(RoutineContext routineContext, RoutinePipeline routinePipeline);
}
