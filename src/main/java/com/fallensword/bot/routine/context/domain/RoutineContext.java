package com.fallensword.bot.routine.context.domain;

import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.domain.world.World;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoutineContext {

    private final Player player;
    private final World world;
}
