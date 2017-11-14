package com.fallensword.bot.request.client.type.info.domain;

import com.fallensword.bot.request.client.Response;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerInfoResponse implements Response {

  private final PlayerPartialResponse player;
}
