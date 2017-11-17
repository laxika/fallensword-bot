package com.fallensword.bot.routine.configuration;

import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.handler.impl.CheckAvailableStaminaRoutineHandler;
import com.fallensword.bot.routine.pipeline.handler.impl.ClearTileRoutineHandler;
import com.fallensword.bot.routine.pipeline.handler.impl.MoveRoutineHandler;
import com.fallensword.bot.routine.pipeline.handler.impl.RefreshInfoRoutineHandler;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RoutineConfiguration {

    private final RefreshInfoRoutineHandler refreshInfoRoutineHandler;
    private final CheckAvailableStaminaRoutineHandler checkAvailableStaminaRoutineHandler;
    private final ClearTileRoutineHandler clearTileRoutineHandler;
    private final MoveRoutineHandler moveRoutineHandler;

    @Bean
    public RoutinePipeline routinePipeline() {
        return new RoutinePipeline(
                Lists.newArrayList(
                        refreshInfoRoutineHandler,
                        checkAvailableStaminaRoutineHandler,
                        clearTileRoutineHandler,
                        moveRoutineHandler
                )
        );
    }
}
