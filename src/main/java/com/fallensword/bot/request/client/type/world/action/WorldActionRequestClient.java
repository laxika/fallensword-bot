package com.fallensword.bot.request.client.type.world.action;

import com.fallensword.bot.request.client.RequestClient;
import com.fallensword.bot.request.client.RequestResolver;
import com.fallensword.bot.request.client.domain.Action;
import com.fallensword.bot.request.client.domain.FetchFlag;
import com.fallensword.bot.request.client.type.world.action.domain.WorldActionRequest;
import com.fallensword.bot.request.client.type.world.action.domain.WorldActionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldActionRequestClient implements RequestClient<WorldActionRequest, WorldActionResponse> {

    private final RequestResolver requestResolver;

    @Override
    public WorldActionResponse request(final WorldActionRequest request) {
        return requestResolver
                .executeRequest(Action.INFO, FetchFlag.AVAILABLE_ACTIONS, WorldActionResponse.class);
    }
}
