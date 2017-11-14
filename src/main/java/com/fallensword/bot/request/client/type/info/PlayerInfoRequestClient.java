package com.fallensword.bot.request.client.type.info;

import com.fallensword.bot.request.client.RequestClient;
import com.fallensword.bot.request.client.RequestResolver;
import com.fallensword.bot.request.client.domain.Action;
import com.fallensword.bot.request.client.domain.FetchFlag;
import com.fallensword.bot.request.client.type.info.domain.PlayerInfoRequest;
import com.fallensword.bot.request.client.type.info.domain.PlayerInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerInfoRequestClient implements RequestClient<PlayerInfoRequest, PlayerInfoResponse> {

    private final RequestResolver requestResolver;

    @Override
    public PlayerInfoResponse request(final PlayerInfoRequest request) {
        return requestResolver
                .executeRequest(Action.INFO, FetchFlag.PLAYER_INFO, PlayerInfoResponse.class);
    }
}
