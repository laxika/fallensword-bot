package com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic.type;

import com.fallensword.bot.api.endpoint.info.domain.response.world.dynamic.RawDynamicEntryPartialResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RawUnknownDynamicEntryPartialResponse implements RawDynamicEntryPartialResponse {

    private final int id;
    private final int type;
    private final int x;
    private final int y;
}
