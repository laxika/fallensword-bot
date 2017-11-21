package com.fallensword.bot.world.domain.dynamic;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnknownDynamicEntry implements DynamicEntry {

    private final int id;
    private final int type;
    private final int x;
    private final int y;
}
