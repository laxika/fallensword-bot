package com.fallensword.bot.api.endpoint.attack.domain;

import com.fallensword.bot.api.domain.Context;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.creature.CreatureWorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttackRequestContext implements Context {

    private final TargetCreature creature;
}
