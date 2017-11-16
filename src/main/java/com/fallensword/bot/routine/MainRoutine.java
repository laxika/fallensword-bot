package com.fallensword.bot.routine;

import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.domain.world.World;
import com.fallensword.bot.api.domain.world.action.CreatureAvailableAction;
import com.fallensword.bot.api.endpoint.attack.AttackEndpoint;
import com.fallensword.bot.api.endpoint.attack.domain.AttackContext;
import com.fallensword.bot.api.endpoint.attack.domain.TargetCreature;
import com.fallensword.bot.api.endpoint.info.FetchInfoEndpoint;
import com.fallensword.bot.api.endpoint.info.domain.FetchInfoContext;
import com.fallensword.bot.api.endpoint.movement.MovementEndpoint;
import com.fallensword.bot.routine.wait.WaitingService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainRoutine {

    private final AttackEndpoint attackEndpoint;
    private final MovementEndpoint movementEndpoint;
    private final WaitingService waitingService;
private final FetchInfoEndpoint fetchInfoEndpoint;

    //Very VERY dumb test AI
    public void startBotRoutine() {
        //Initialize the player
        final Player player = Player.builder()
                .build();
        final World world = World.builder()
                .build();

        while (true) {
            fetchInfoEndpoint.request(
                    FetchInfoContext.builder()
                            .player(player)
                            .world(world)
                            .flags(
                                    Lists.newArrayList(
                                            FetchFlag.PLAYER_INFO,
                                            FetchFlag.AVAILABLE_ACTIONS
                                    )
                            )
                            .build()
            );

            waitingService.randomWait(2000);

            world.getAvailableActions().stream()
                    .filter(worldInfoActionEntry -> worldInfoActionEntry instanceof CreatureAvailableAction)
                    .forEach(worldInfoActionEntry -> {
                        final CreatureAvailableAction creatureAvailableAction =
                                (CreatureAvailableAction) worldInfoActionEntry;

                        attackEndpoint.request(
                                AttackContext.builder()
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
