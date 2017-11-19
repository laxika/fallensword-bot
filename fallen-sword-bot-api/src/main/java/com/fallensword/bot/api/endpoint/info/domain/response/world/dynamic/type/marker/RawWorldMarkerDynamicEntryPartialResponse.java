package com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic.type.marker;

import com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic.RawDynamicEntryPartialResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RawWorldMarkerDynamicEntryPartialResponse implements RawDynamicEntryPartialResponse {

    private final int id;
    private final String name;
    private final int type;
    private final int subtype;
    private final int x;
    private final int y;
}
