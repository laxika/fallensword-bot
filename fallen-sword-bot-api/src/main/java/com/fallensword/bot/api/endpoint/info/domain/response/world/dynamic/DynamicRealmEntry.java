package com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic;

import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.teleport.TeleportWorldInfoActionEntry;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TeleportWorldInfoActionEntry.class, name = DynamicRealmEntryType.MAP_MARKER_TYPE_ID),
})
public interface DynamicRealmEntry {
}
