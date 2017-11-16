package com.fallensword.bot.api.endpoint.info.service.action;

import com.fallensword.bot.api.domain.world.action.*;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.WorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.creature.CreatureWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.creature.CreatureWorldInfoActionEntryData;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.player.PlayerWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.player.PlayerWorldInfoActionEntryData;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.quest.QuestWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.quest.QuestWorldInfoActionEntryData;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.teleport.TeleportWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.teleport.TeleportWorldInfoActionEntryData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionTransformer {

    public List<AvailableAction> transform(final List<WorldInfoActionEntry> worldInfoActionEntries) {
        return worldInfoActionEntries.stream()
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
                    } else if (action instanceof QuestWorldInfoActionEntry) {
                        final QuestWorldInfoActionEntryData questWorldInfoActionEntryData =
                                ((QuestWorldInfoActionEntry) action).getData();

                        return QuestAvailableAction.builder()
                                .id(questWorldInfoActionEntryData.getId())
                                .name(questWorldInfoActionEntryData.getName())
                                .stage(questWorldInfoActionEntryData.getStage())
                                .build();
                    }

                    throw new IllegalStateException("Unknown action type: " + action.getClass());
                })
                .collect(Collectors.toList());
    }
}
