package com.fallensword.bot.routine.pipeline.handler.impl;

import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.endpoint.info.FetchInfoEndpoint;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoContext;
import com.fallensword.bot.routine.WaitingService;
import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import com.fallensword.bot.routine.pipeline.handler.RoutineHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

/**
 * This {@link RoutineHandler} will update the player and the world information.
 */
@Service
@RequiredArgsConstructor
public class RefreshInfoRoutineHandler implements RoutineHandler {

    private final FetchInfoEndpoint fetchInfoEndpoint;
    private final WaitingService waitingService;

    @Override
    public void handle(RoutineContext routineContext, RoutinePipeline routinePipeline) {
        fetchInfoEndpoint.request(
                FetchInfoContext.builder()
                        .player(routineContext.getPlayer())
                        .world(routineContext.getWorld())
                        .flags(
                                EnumSet.of(
                                        FetchFlag.PLAYER_INFO,
                                        FetchFlag.AVAILABLE_ACTIONS
                                )
                        )
                        .build()
        );

        waitingService.randomWait(2000);

        routinePipeline.proceedWithRoutine(routineContext);
    }
}
