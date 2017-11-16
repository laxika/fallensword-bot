package com.fallensword.bot.routine.context;

import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.domain.world.World;
import com.fallensword.bot.api.endpoint.info.FetchInfoEndpoint;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoContext;
import com.fallensword.bot.routine.context.domain.RoutineContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
@RequiredArgsConstructor
public class RoutineContextFactory {

    private final FetchInfoEndpoint fetchInfoEndpoint;

    public RoutineContext buildNewContext() {
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

        return RoutineContext.builder()
                .player(player)
                .world(world)
                .build();
    }
}
