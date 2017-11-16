package com.fallensword.bot.api.endpoint.info.service.world;

import com.fallensword.bot.api.domain.world.tile.WorldTile;
import org.springframework.stereotype.Service;

@Service
public class TileDataTransformer {

    private static char NON_WALKABLE_TILE_ID = '0';

    public WorldTile[][] transform(final int width, final int height, final String blockData) {
        int[] counter = {0};

        return blockData.chars()
                .mapToObj(i -> (char) i)
                .map(character ->
                        WorldTile.builder()
                                .walkable(character == NON_WALKABLE_TILE_ID)
                                .build()
                )
                .collect(
                        () -> new WorldTile[height][width],
                        (a, i) -> a[counter[0] / width][counter[0]++ % width] = i,
                        (a, i) -> {
                        }
                );
    }
}
