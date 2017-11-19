package com.fallensword.bot.api.endpoint.info.domain.response.world;

import com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic.type.marker.RawWorldMarkerDynamicEntryPartialResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class RealmPartialResponse {

    private final int w;
    private final int h;
    private final String block;
    private final List<RawWorldMarkerDynamicEntryPartialResponse> dynamic;
}
