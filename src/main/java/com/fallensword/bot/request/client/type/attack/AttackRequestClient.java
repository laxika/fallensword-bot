package com.fallensword.bot.request.client.type.attack;

import com.fallensword.bot.request.client.RequestClient;
import com.fallensword.bot.request.client.RequestResolver;
import com.fallensword.bot.request.client.domain.Action;
import com.fallensword.bot.request.client.domain.FetchFlag;
import com.fallensword.bot.request.client.type.attack.domain.AttackRequestRequest;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttackRequestClient implements RequestClient<AttackRequestRequest, AttackRequestResponse> {

    private final RequestResolver requestResolver;

    @Override
    public AttackRequestResponse request(final AttackRequestRequest request) {
        log.info("Attacking Lvl " + request.getCreature().getData().getLevel() + " "
                + request.getCreature().getData().getName());

        final Map<String, String> parameters = ImmutableMap.of(
                "id", String.valueOf(request.getCreature().getData().getId()),
                "ac", request.getCreature().getData().getAc()
        );

        return requestResolver
                .executeRequest(Action.INFO, FetchFlag.PLAYER_INFO, parameters, AttackRequestResponse.class);
    }
}
