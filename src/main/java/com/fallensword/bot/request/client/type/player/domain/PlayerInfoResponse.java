package com.fallensword.bot.request.client.type.player.domain;

import com.fallensword.bot.request.client.domain.Response;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerInfoResponse implements Response {

    private final PlayerPartialResponse player;
}
