package com.fallensword.bot.request.client.type.player.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerPartialResponse {

    private final String username;
}
