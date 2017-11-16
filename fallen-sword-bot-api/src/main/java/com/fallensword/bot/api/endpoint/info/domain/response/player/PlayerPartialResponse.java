package com.fallensword.bot.api.endpoint.info.domain.response.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PlayerPartialResponse {

    private String username;

    @JsonProperty("realm_id")
    private int realmId;

    private PlayerStaminaPartialResponse stamina;
}
