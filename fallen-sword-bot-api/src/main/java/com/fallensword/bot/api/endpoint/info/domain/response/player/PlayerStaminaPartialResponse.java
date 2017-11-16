package com.fallensword.bot.api.endpoint.info.domain.response.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerStaminaPartialResponse {

    private final int current;
    @JsonProperty("max")
    private final int maximum;
}
