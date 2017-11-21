package com.fallensword.bot.api.endpoint.info.service.world;

import com.fallensword.bot.world.domain.dynamic.DynamicEntry;
import com.fallensword.bot.world.domain.dynamic.UnknownDynamicEntry;
import com.fallensword.bot.world.domain.dynamic.WorldMarkerDynamicEntry;
import com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic.RawDynamicEntryPartialResponse;
import com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic.type.RawUnknownDynamicEntryPartialResponse;
import com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic.type.marker.RawWorldMarkerDynamicEntryPartialResponse;
import org.springframework.stereotype.Service;

@Service
public class DynamicEntryTransformer {

    public DynamicEntry transform(final RawDynamicEntryPartialResponse rawDynamicEntryPartialResponse) {
        if (rawDynamicEntryPartialResponse instanceof RawWorldMarkerDynamicEntryPartialResponse) {
            final RawWorldMarkerDynamicEntryPartialResponse worldMarkerDynamicEntry =
                    (RawWorldMarkerDynamicEntryPartialResponse) rawDynamicEntryPartialResponse;

            return WorldMarkerDynamicEntry.builder()
                    .id(worldMarkerDynamicEntry.getId())
                    .name(worldMarkerDynamicEntry.getName())
                    .type(worldMarkerDynamicEntry.getType())
                    .subtype(worldMarkerDynamicEntry.getSubtype())
                    .x(worldMarkerDynamicEntry.getX())
                    .y(worldMarkerDynamicEntry.getY())
                    .build();
        } else if (rawDynamicEntryPartialResponse instanceof RawUnknownDynamicEntryPartialResponse) {
            final RawUnknownDynamicEntryPartialResponse rawUnknownDynamicEntryPartialResponse =
                    (RawUnknownDynamicEntryPartialResponse) rawDynamicEntryPartialResponse;

            return UnknownDynamicEntry.builder()
                    .id(rawUnknownDynamicEntryPartialResponse.getId())
                    .type(rawUnknownDynamicEntryPartialResponse.getType())
                    .x(rawUnknownDynamicEntryPartialResponse.getX())
                    .y(rawUnknownDynamicEntryPartialResponse.getY())
                    .build();
        }

        throw new IllegalStateException("Unknown dynamic entry: " + rawDynamicEntryPartialResponse);
    }
}
