package com.fallensword.bot.api.endpoint.action;

import com.fallensword.bot.api.RequestResolver;
import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.Endpoint;
import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.endpoint.action.domain.WorldActionContext;
import com.fallensword.bot.api.endpoint.action.domain.WorldActionResult;
import com.fallensword.bot.api.endpoint.action.domain.response.WorldActionResponse;
import com.fallensword.bot.api.endpoint.action.transformer.ActionTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorldActionEndpoint implements Endpoint<WorldActionContext, WorldActionResult> {

    private final RequestResolver requestResolver;
    private final ActionTransformer actionTransformer;

    @Override
    public WorldActionResult request(final WorldActionContext request) {
        log.info("Requesting available actions in the world.");

        final WorldActionResponse worldActionResponse = requestResolver
                .executeRequest(Action.INFO, FetchFlag.AVAILABLE_ACTIONS, WorldActionResponse.class);

        return actionTransformer.transform(worldActionResponse);
    }
}
