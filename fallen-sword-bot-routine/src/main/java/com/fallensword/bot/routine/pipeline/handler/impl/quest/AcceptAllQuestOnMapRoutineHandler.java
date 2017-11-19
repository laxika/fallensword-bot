package com.fallensword.bot.routine.pipeline.handler.impl.quest;

import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import com.fallensword.bot.routine.pipeline.handler.RoutineHandler;
import org.springframework.stereotype.Service;

@Service
public class AcceptAllQuestOnMapRoutineHandler implements RoutineHandler {

    @Override
    public void handle(RoutineContext routineContext, RoutinePipeline routinePipeline) {
        routinePipeline.proceedWithRoutine(routineContext);
    }
}
