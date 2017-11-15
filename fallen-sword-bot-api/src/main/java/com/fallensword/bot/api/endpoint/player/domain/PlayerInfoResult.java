package com.fallensword.bot.api.endpoint.player.domain;

import com.fallensword.bot.api.domain.Result;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerInfoResult implements Result {

    private final PlayerPartialResponse player;
}
