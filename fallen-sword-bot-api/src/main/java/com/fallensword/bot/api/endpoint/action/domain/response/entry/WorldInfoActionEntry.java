package com.fallensword.bot.api.endpoint.action.domain.response.entry;

import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.creature.CreatureWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.player.PlayerWorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.action.domain.response.entry.type.teleport.TeleportWorldInfoActionEntry;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TeleportWorldInfoActionEntry.class, name = WorldInfoActionEntryType.TELEPORT_TYPE_ID),
        @JsonSubTypes.Type(value = CreatureWorldInfoActionEntry.class, name = WorldInfoActionEntryType.CREATURE_TYPE_ID),
        @JsonSubTypes.Type(value = PlayerWorldInfoActionEntry.class, name = WorldInfoActionEntryType.PLAYER_TYPE_ID),
})
public interface WorldInfoActionEntry {
}
