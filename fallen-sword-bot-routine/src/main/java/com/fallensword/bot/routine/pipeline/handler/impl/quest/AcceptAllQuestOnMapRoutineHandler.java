package com.fallensword.bot.routine.pipeline.handler.impl.quest;

import com.fallensword.bot.api.domain.world.dynamic.WorldMarkerDynamicEntry;
import com.fallensword.bot.movement.MovementFacade;
import com.fallensword.bot.location.domain.Location;
import com.fallensword.bot.routine.pipeline.RoutinePipeline;
import com.fallensword.bot.routine.pipeline.domain.RoutineContext;
import com.fallensword.bot.routine.pipeline.handler.RoutineHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcceptAllQuestOnMapRoutineHandler implements RoutineHandler {

    private static final int WORLD_MARKER_ENTRY_TYPE_ID = 2;
    private static final int QUEST_WORLD_MARKER_ENTRY_SUBTYPE_ID = 0;

    private final MovementFacade movementFacade;

    @Override
    public void handle(RoutineContext routineContext, RoutinePipeline routinePipeline) {
        final Optional<WorldMarkerDynamicEntry> dynamicEntry = routineContext.getWorld().getDynamicEntries().stream()
                .filter(dynamicEntry1 -> dynamicEntry1 instanceof WorldMarkerDynamicEntry)
                .map(dynamicEntry1 -> (WorldMarkerDynamicEntry) dynamicEntry1)
                .filter(worldMarkerDynamicEntry -> worldMarkerDynamicEntry.getType() == WORLD_MARKER_ENTRY_TYPE_ID
                        && worldMarkerDynamicEntry.getSubtype() == QUEST_WORLD_MARKER_ENTRY_SUBTYPE_ID)
                .findFirst();

        if (dynamicEntry.isPresent()) {
            final WorldMarkerDynamicEntry worldMarkerDynamicEntry = dynamicEntry.get();

            if (worldMarkerDynamicEntry.getX() == routineContext.getPlayer().getLocationX()
                    && worldMarkerDynamicEntry.getY() == routineContext.getPlayer().getLocationY()) {
                System.out.println("FOUND IT!");
            } else {
                //TODO: Go for the quest
                movementFacade.moveTowardsTile(
                        Location.builder()
                                .x(worldMarkerDynamicEntry.getX())
                                .y(worldMarkerDynamicEntry.getY())
                                .build(),
                        routineContext.getPlayer(),
                        routineContext.getWorld()
                );
                System.out.println("MOVING TO!");
            }
        } else {
            routinePipeline.proceedWithRoutine(routineContext);
        }
    }
}
