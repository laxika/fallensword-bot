package com.fallensword.bot.routine;

import com.fallensword.bot.api.endpoint.action.WorldActionEndpoint;
import com.fallensword.bot.api.endpoint.action.domain.WorldActionContext;
import com.fallensword.bot.api.endpoint.action.domain.WorldActionResult;
import com.fallensword.bot.api.endpoint.action.domain.action.CreatureAvailableAction;
import com.fallensword.bot.api.endpoint.attack.AttackEndpoint;
import com.fallensword.bot.api.endpoint.attack.domain.AttackRequestContext;
import com.fallensword.bot.api.endpoint.attack.domain.TargetCreature;
import com.fallensword.bot.routine.wait.WaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainRoutine {

    private final WorldActionEndpoint worldActionRequestClient;
    private final AttackEndpoint attackRequestClient;
    private final WaitingService waitingService;

    //Very VERY dumb test AI
    public void startBotRoutine() {
        while (true) {
            //Attack all monsters on the map if possible
            final WorldActionResult worldActionResponse = worldActionRequestClient.request(
                    WorldActionContext.builder().build()
            );
            waitingService.randomWait(2000);

            worldActionResponse.getAvailableActions().stream()
                    .filter(worldInfoActionEntry -> worldInfoActionEntry instanceof CreatureAvailableAction)
                    .forEach(worldInfoActionEntry -> {
                        final CreatureAvailableAction creatureAvailableAction =
                                (CreatureAvailableAction) worldInfoActionEntry;

                        attackRequestClient.request(
                                AttackRequestContext.builder()
                                        .creature(
                                                TargetCreature.builder()
                                                        .id(creatureAvailableAction.getId())
                                                        .ac(creatureAvailableAction.getAc())
                                                        .name(creatureAvailableAction.getName())
                                                        .level(creatureAvailableAction.getLevel())
                                                        .build()
                                        )
                                        .build()
                        );

                        waitingService.randomWait(2000);
                    });
        }
    }
}
