package com.fallensword.bot.world.domain.dynamic;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WorldMarkerDynamicEntry implements DynamicEntry {

    private final int id;
    private final String name;
    private final int type;
    private final int subtype;
    private final int x;
    private final int y;
}
