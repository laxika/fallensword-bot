package com.fallensword.bot.request.client.type.world;

import com.fallensword.bot.request.client.RequestClient;
import com.fallensword.bot.request.client.RequestResolver;
import com.fallensword.bot.request.client.domain.Action;
import com.fallensword.bot.request.client.domain.FetchFlag;
import com.fallensword.bot.request.client.type.world.domain.WorldInfoRequest;
import com.fallensword.bot.request.client.type.world.domain.WorldInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldInfoRequestClient implements RequestClient<WorldInfoRequest, WorldInfoResponse> {

    private final RequestResolver requestResolver;

    @Override
    public WorldInfoResponse request(final WorldInfoRequest request) {
        return requestResolver
                .executeRequest(Action.INFO, FetchFlag.AVAILABLE_ACTIONS, WorldInfoResponse.class);
    }
}
