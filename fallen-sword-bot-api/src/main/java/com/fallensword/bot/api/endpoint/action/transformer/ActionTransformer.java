package com.fallensword.bot.api.endpoint.action.transformer;

import com.fallensword.bot.api.endpoint.action.domain.WorldActionResult;
import com.fallensword.bot.api.endpoint.action.domain.action.AvailableAction;
import com.fallensword.bot.api.endpoint.action.domain.action.CreatureAvailableAction;
import com.fallensword.bot.api.endpoint.action.domain.action.PlayerAvailableAction;
import com.fallensword.bot.api.endpoint.action.domain.action.TeleportAvailableAction;
import com.fallensword.bot.api.endpoint.action.domain.response.WorldActionResponse;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.creature.CreatureWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.creature.CreatureWorldInfoActionEntryData;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.player.PlayerWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.player.PlayerWorldInfoActionEntryData;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.teleport.TeleportWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.teleport.TeleportWorldInfoActionEntryData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionTransformer {

    public WorldActionResult transform(final WorldActionResponse worldActionResponse) {
        final List<AvailableAction> availableActions = worldActionResponse.getActions().stream()
                .map(action -> {
                    if (action instanceof CreatureWorldInfoActionEntry) {
                        final CreatureWorldInfoActionEntryData creatureWorldInfoActionEntry =
                                ((CreatureWorldInfoActionEntry) action).getData();

                        return CreatureAvailableAction.builder()
                                .id(creatureWorldInfoActionEntry.getId())
                                .ac(creatureWorldInfoActionEntry.getAc())
                                .name(creatureWorldInfoActionEntry.getName())
                                .level(creatureWorldInfoActionEntry.getLevel())
                                .build();
                    } else if (action instanceof PlayerWorldInfoActionEntry) {
                        final PlayerWorldInfoActionEntryData playerWorldInfoActionEntryData =
                                ((PlayerWorldInfoActionEntry) action).getData();

                        return PlayerAvailableAction.builder()
                                .id(playerWorldInfoActionEntryData.getId())
                                .name(playerWorldInfoActionEntryData.getName())
                                .level(playerWorldInfoActionEntryData.getLevel())
                                .guildId(playerWorldInfoActionEntryData.getGuildId())
                                .build();
                    } else if (action instanceof TeleportWorldInfoActionEntry) {
                        final TeleportWorldInfoActionEntryData teleportWorldInfoActionEntryData =
                                ((TeleportWorldInfoActionEntry) action).getData();

                        return TeleportAvailableAction.builder()
                                .id(teleportWorldInfoActionEntryData.getId())
                                .name(teleportWorldInfoActionEntryData.getName())
                                .build();
                    }

                    throw new IllegalStateException("Unknown action type: " + action.getClass());
                })
                .collect(Collectors.toList());

        return WorldActionResult.builder()
                .availableActions(availableActions)
                .build();
    }
}
