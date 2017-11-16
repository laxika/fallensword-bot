package com.fallensword.bot.api.endpoint.movement;

import com.fallensword.bot.api.RequestResolver;
import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.Endpoint;
import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.endpoint.movement.domain.MovementContext;
import com.fallensword.bot.api.endpoint.movement.domain.MovementResult;
import com.fallensword.bot.api.endpoint.movement.domain.response.MovementResponse;
import com.fallensword.bot.api.endpoint.info.service.player.PlayerUpdater;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovementEndpoint implements Endpoint<MovementContext, MovementResult> {

    private final RequestResolver requestResolver;
    private final PlayerUpdater playerUpdater;

    @Override
    public MovementResult request(final MovementContext context) {
        log.info("Moving to location " + context.getTargetX() + "/" + context.getTargetY());

        final MovementResponse movementResponse = requestResolver.executeRequest(Action.MOVE, FetchFlag.PLAYER_INFO,
                buildRequestParameters(context), MovementResponse.class);

        playerUpdater.updatePlayer(context.getPlayer(), movementResponse.getPlayer());

        return MovementResult.builder()
                .build();
    }

    private Map<String, String> buildRequestParameters(final MovementContext context) {
        return ImmutableMap.of(
                "x", String.valueOf(context.getTargetX()),
                "y", String.valueOf(context.getTargetY())
        );
    }
}
