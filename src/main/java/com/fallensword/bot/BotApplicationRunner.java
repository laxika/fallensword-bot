package com.fallensword.bot;

import com.fallensword.bot.routine.MainRoutine;
import com.fallensword.bot.routine.context.RoutineContextFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BotApplicationRunner implements ApplicationRunner {

    private final RoutineContextFactory routineContextFactory;
    private final MainRoutine mainRoutine;

    @Override
    public void run(ApplicationArguments args) {
        mainRoutine.startBotRoutine(routineContextFactory.buildNewContext());
    }
}
