package com.fallensword.bot;

import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.domain.world.World;
import com.fallensword.bot.api.endpoint.info.FetchInfoEndpoint;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoContext;
import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.EnumSet;

@SpringBootApplication
public class FallenSwordBotApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(FallenSwordBotApplication.class, args);
    }

    @Autowired
    private RoutinePipeline routinePipeline;

    @Autowired
    private FetchInfoEndpoint fetchInfoEndpoint;

    @Override
    public void run(ApplicationArguments args) {
        final Player player = Player.builder()
                .build();
        final World world = World.builder()
                .build();

        fetchInfoEndpoint.request(
                FetchInfoContext.builder()
                        .player(player)
                        .world(world)
                        .flags(
                                EnumSet.of(
                                        FetchFlag.PLAYER_INFO,
                                        FetchFlag.AVAILABLE_ACTIONS,
                                        FetchFlag.STATIC_WORLD_INFO
                                )
                        )
                        .build()
        );

        while (true) {
            routinePipeline.proceedWithRoutine(
                    RoutineContext.builder()
                            .nextRoutineHandlerId(0)
                            .player(player)
                            .world(world)
                            .build()
            );
        }
    }
}
