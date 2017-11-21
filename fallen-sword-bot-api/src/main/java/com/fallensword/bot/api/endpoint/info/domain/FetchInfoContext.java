package com.fallensword.bot.api.endpoint.info.domain;

import com.fallensword.bot.api.domain.Context;
import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.world.domain.World;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class FetchInfoContext implements Context {

    private final Player player;
    private final World world;
    private final Set<FetchFlag> flags;
}
