package com.fallensword.bot.request.client.type.player.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PlayerPartialResponse {

    private String username;

    @JsonProperty("realm_id")
    private int realmId;
}
