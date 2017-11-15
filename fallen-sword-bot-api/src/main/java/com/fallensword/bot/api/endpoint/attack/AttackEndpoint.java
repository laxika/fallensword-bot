package com.fallensword.bot.api.endpoint.attack;

import com.fallensword.bot.api.RequestResolver;
import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.Endpoint;
import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.endpoint.attack.domain.AttackRequestContext;
import com.fallensword.bot.api.endpoint.attack.domain.AttackResult;
import com.fallensword.bot.api.endpoint.attack.domain.response.AttackRequestResponse;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttackEndpoint implements Endpoint<AttackRequestContext, AttackResult> {

    private final RequestResolver requestResolver;

    @Override
    public AttackResult request(final AttackRequestContext request) {
        log.info("Attacking Lvl " + request.getCreature().getLevel() + " "
                + request.getCreature().getName());

        final Map<String, String> parameters = ImmutableMap.of(
                "id", String.valueOf(request.getCreature().getId()),
                "ac", request.getCreature().getAc()
        );

        requestResolver.executeRequest(Action.ATTACK, FetchFlag.PLAYER_INFO, parameters, AttackRequestResponse.class);

        return AttackResult.builder()
                .build();
    }
}
