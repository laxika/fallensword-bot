package com.fallensword.bot.request.client.type.info.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerPartialResponse {

    private final String username;
}
