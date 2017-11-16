package com.fallensword.bot.api.endpoint.movement.domain.response;

import com.fallensword.bot.api.endpoint.info.domain.response.player.PlayerPartialResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovementResponse {

    private final PlayerPartialResponse player;
}
