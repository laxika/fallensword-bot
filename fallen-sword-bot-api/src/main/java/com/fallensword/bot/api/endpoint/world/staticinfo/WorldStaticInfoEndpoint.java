package com.fallensword.bot.api.endpoint.world.staticinfo;

import com.fallensword.bot.api.domain.Endpoint;
import com.fallensword.bot.api.RequestResolver;
import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.endpoint.world.staticinfo.domain.request.WorldStaticInfoContext;
import com.fallensword.bot.api.endpoint.world.staticinfo.domain.response.WorldStaticInfoResult;
import com.fallensword.bot.api.endpoint.world.staticinfo.domain.response.raw.RawWorldStaticInfoResponse;
import com.fallensword.bot.api.endpoint.world.staticinfo.transformer.WorldStaticInfoResponseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldStaticInfoEndpoint implements Endpoint<WorldStaticInfoContext, WorldStaticInfoResult> {

    private final RequestResolver requestResolver;
    private final WorldStaticInfoResponseTransformer worldStaticInfoResponseTransformer;

    @Override
    public WorldStaticInfoResult request(final WorldStaticInfoContext request) {
        final RawWorldStaticInfoResponse rawWorldStaticInfoResponse = requestResolver
                .executeRequest(Action.INFO, FetchFlag.STATIC_WORLD_INFO, RawWorldStaticInfoResponse.class);

        return worldStaticInfoResponseTransformer.transform(rawWorldStaticInfoResponse);
    }
}
