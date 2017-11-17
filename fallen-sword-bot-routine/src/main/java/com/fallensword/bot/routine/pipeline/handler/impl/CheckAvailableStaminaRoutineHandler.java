package com.fallensword.bot.routine.pipeline.handler.impl;

import com.fallensword.bot.routine.WaitingService;
import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import com.fallensword.bot.routine.pipeline.handler.RoutineHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckAvailableStaminaRoutineHandler implements RoutineHandler {

    private final WaitingService waitingService;

    @Override
    public void handle(RoutineContext routineContext, RoutinePipeline routinePipeline) {
        if (routineContext.getPlayer().getCurrentStamina() == 0) {
            log.info("Ran out of stamina. ");

            waitingService.randomWait(900000);
        } else {
            routinePipeline.proceedWithRoutine(routineContext);
        }
    }
}
