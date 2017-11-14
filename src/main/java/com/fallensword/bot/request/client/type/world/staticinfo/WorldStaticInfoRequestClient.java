package com.fallensword.bot.request.client.type.world.staticinfo;

import com.fallensword.bot.request.client.RequestClient;
import com.fallensword.bot.request.client.RequestResolver;
import com.fallensword.bot.request.client.domain.Action;
import com.fallensword.bot.request.client.domain.FetchFlag;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.WorldStaticInfoRequest;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.WorldStaticInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldStaticInfoRequestClient implements RequestClient<WorldStaticInfoRequest, WorldStaticInfoResponse> {

    private final RequestResolver requestResolver;

    @Override
    public WorldStaticInfoResponse request(final WorldStaticInfoRequest request) {
        return requestResolver
                .executeRequest(Action.INFO, FetchFlag.STATIC_WORLD_INFO, WorldStaticInfoResponse.class);
    }
}
