package com.fallensword.bot.api.endpoint.info.domain.response.player;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerLocationPartialResponse {

    private final int x;
    private final int y;
}
