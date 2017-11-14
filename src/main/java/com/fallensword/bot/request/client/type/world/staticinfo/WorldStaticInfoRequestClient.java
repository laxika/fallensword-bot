package com.fallensword.bot.request.client.type.world.staticinfo;

import com.fallensword.bot.request.client.RequestClient;
import com.fallensword.bot.request.client.RequestResolver;
import com.fallensword.bot.request.client.domain.Action;
import com.fallensword.bot.request.client.domain.FetchFlag;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.request.WorldStaticInfoRequest;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.response.WorldStaticInfoResponse;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.response.raw.RawWorldStaticInfoResponse;
import com.fallensword.bot.request.client.type.world.staticinfo.transformer.WorldStaticInfoResponseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldStaticInfoRequestClient implements RequestClient<WorldStaticInfoRequest, WorldStaticInfoResponse> {

    private final RequestResolver requestResolver;
    private final WorldStaticInfoResponseTransformer worldStaticInfoResponseTransformer;

    @Override
    public WorldStaticInfoResponse request(final WorldStaticInfoRequest request) {
        final RawWorldStaticInfoResponse rawWorldStaticInfoResponse = requestResolver
                .executeRequest(Action.INFO, FetchFlag.STATIC_WORLD_INFO, RawWorldStaticInfoResponse.class);

        return worldStaticInfoResponseTransformer.transform(rawWorldStaticInfoResponse);
    }
}
