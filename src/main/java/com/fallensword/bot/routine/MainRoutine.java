package com.fallensword.bot.routine;

import com.fallensword.bot.request.client.type.attack.AttackRequestClient;
import com.fallensword.bot.request.client.type.attack.domain.AttackRequestRequest;
import com.fallensword.bot.request.client.type.world.action.WorldActionRequestClient;
import com.fallensword.bot.request.client.type.world.action.domain.WorldActionRequest;
import com.fallensword.bot.request.client.type.world.action.domain.WorldActionResponse;
import com.fallensword.bot.request.client.type.world.action.domain.entry.type.creature.CreatureWorldInfoActionEntry;
import com.fallensword.bot.request.client.type.world.action.domain.entry.type.creature.CreatureWorldInfoActionEntryData;
import com.fallensword.bot.routine.wait.WaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainRoutine {

    private final WorldActionRequestClient worldActionRequestClient;
    private final AttackRequestClient attackRequestClient;
    private final WaitingService waitingService;

    //Very VERY dumb test AI
    public void startBotRoutine() {
        //Attack all monsters on the map if possible
        final WorldActionResponse worldActionResponse = worldActionRequestClient.request(
                WorldActionRequest.builder().build()
        );

        worldActionResponse.getActions().stream()
                .filter(worldInfoActionEntry -> worldInfoActionEntry instanceof CreatureWorldInfoActionEntry)
                .forEach(worldInfoActionEntry -> {
                    attackRequestClient.request(
                            AttackRequestRequest.builder()
                                    .creature((CreatureWorldInfoActionEntry) worldInfoActionEntry)
                                    .build()
                    );

                    waitingService.randomWait(2000);
                });
    }
}
