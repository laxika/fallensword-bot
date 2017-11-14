package com.fallensword.bot.request.client.type.attack.domain;

import com.fallensword.bot.request.client.domain.Request;
import com.fallensword.bot.request.client.type.world.action.domain.entry.type.creature.CreatureWorldInfoActionEntry;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttackRequestRequest implements Request {

    private final CreatureWorldInfoActionEntry creature;
}
