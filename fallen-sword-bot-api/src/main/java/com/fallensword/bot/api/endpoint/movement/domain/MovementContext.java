package com.fallensword.bot.api.endpoint.movement.domain;

import com.fallensword.bot.api.domain.Context;
import com.fallensword.bot.api.domain.player.Player;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovementContext implements Context {

  private final Player player;
  private final int targetX;
  private final int targetY;
}
