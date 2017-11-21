package com.fallensword.bot.routine.pipeline.domain;

import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.world.domain.World;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoutineContext {

    private final int nextRoutineHandlerId;
    private final Player player;
    private final World world;
}
