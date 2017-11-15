package com.fallensword.bot.api.endpoint.player;

import com.fallensword.bot.api.domain.Endpoint;
import com.fallensword.bot.api.RequestResolver;
import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.endpoint.player.domain.PlayerInfoContext;
import com.fallensword.bot.api.endpoint.player.domain.PlayerInfoResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerInfoEndpoint implements Endpoint<PlayerInfoContext, PlayerInfoResult> {

    private final RequestResolver requestResolver;

    @Override
    public PlayerInfoResult request(final PlayerInfoContext request) {
        return requestResolver
                .executeRequest(Action.INFO, FetchFlag.PLAYER_INFO, PlayerInfoResult.class);
    }
}
