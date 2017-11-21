package com.fallensword.bot.world.service.definition;

import com.fallensword.bot.world.service.definition.domain.WorldDefinition;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WorldDefinitionCache {

    private final Map<Integer, WorldDefinition> worldDefinitions;

    public WorldDefinitionCache(final WorldDefinitionLoader worldDefinitionLoader) {
        worldDefinitions = new HashMap<>();

        //TODO
    }
}
