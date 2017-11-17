package com.fallensword.bot.api.endpoint.info;

import com.fallensword.bot.api.RequestResolver;
import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.Endpoint;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoContext;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoResult;
import com.fallensword.bot.api.endpoint.info.domain.response.FetchInfoResponse;
import com.fallensword.bot.api.endpoint.info.service.action.ActionUpdater;
import com.fallensword.bot.api.endpoint.info.service.player.PlayerUpdater;
import com.fallensword.bot.api.endpoint.info.service.world.WorldUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Update the full data of the player by fetching all of the required information.
 */
@Service
@RequiredArgsConstructor
public class FetchInfoEndpoint implements Endpoint<FetchInfoContext, FetchInfoResult> {

    private final RequestResolver requestResolver;
    private final PlayerUpdater playerUpdater;
    private final ActionUpdater actionUpdater;
    private final WorldUpdater worldUpdater;

    @Override
    public FetchInfoResult request(final FetchInfoContext context) {
        final FetchInfoResponse fetchInfoResponse = requestResolver
                .executeRequest(Action.INFO, context.getFlags(), FetchInfoResponse.class);

        //TODO: Do this in a filter
        playerUpdater.updatePlayer(context.getPlayer(), fetchInfoResponse.getPlayer());
        actionUpdater.updateActions(context.getWorld(), fetchInfoResponse.getActions());
        worldUpdater.updateWorld(context.getWorld(), fetchInfoResponse.getRealm());

        return FetchInfoResult.builder()
                .build();
    }
}
