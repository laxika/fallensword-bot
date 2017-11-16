package com.fallensword.bot.api.endpoint.info;

import com.fallensword.bot.api.RequestResolver;
import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.Endpoint;
import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoContext;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoResult;
import com.fallensword.bot.api.endpoint.info.domain.response.FetchInfoResponse;
import com.fallensword.bot.api.endpoint.info.service.action.ActionUpdater;
import com.fallensword.bot.api.endpoint.info.service.player.PlayerUpdater;
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

    @Override
    public FetchInfoResult request(final FetchInfoContext context) {
        final int fetchValue = context.getFlags().stream()
                .map(FetchFlag::getId)
                .mapToInt(Integer::intValue)
                .sum();

        final FetchInfoResponse fetchInfoResponse = requestResolver
                .executeRequest(Action.INFO, fetchValue, FetchInfoResponse.class);

        //TODO: Do this in a filter
        playerUpdater.updatePlayer(context.getPlayer(), fetchInfoResponse.getPlayer());
        actionUpdater.updateActions(context.getWorld(), fetchInfoResponse.getActions());

        return FetchInfoResult.builder()
                .build();
    }
}