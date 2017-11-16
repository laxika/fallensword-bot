package com.fallensword.bot.api.endpoint.attack.domain;

import com.fallensword.bot.api.domain.Context;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttackContext implements Context {

    private final TargetCreature creature;
}
