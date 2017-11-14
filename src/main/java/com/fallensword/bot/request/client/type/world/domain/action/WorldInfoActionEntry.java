package com.fallensword.bot.request.client.type.world.domain.action;

import com.fallensword.bot.request.client.type.world.domain.action.type.creature.CreatureWorldInfoActionEntry;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreatureWorldInfoActionEntry.class, name = WorldInfoActionEntryType.CREATURE_TYPE_ID),
})
public interface WorldInfoActionEntry {
}
