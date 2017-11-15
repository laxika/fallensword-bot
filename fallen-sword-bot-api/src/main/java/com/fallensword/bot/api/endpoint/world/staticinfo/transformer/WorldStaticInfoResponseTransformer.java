package com.fallensword.bot.api.endpoint.world.staticinfo.transformer;

import com.fallensword.bot.api.endpoint.world.staticinfo.domain.response.WorldStaticInfoResult;
import com.fallensword.bot.api.endpoint.world.staticinfo.domain.response.domain.WorldTile;
import com.fallensword.bot.api.endpoint.world.staticinfo.domain.response.raw.RawWorldStaticInfoResponse;
import org.springframework.stereotype.Service;

@Service
public class WorldStaticInfoResponseTransformer {

    private static char NON_WALKABLE_TILE_ID = '0';

    public WorldStaticInfoResult transform(final RawWorldStaticInfoResponse rawWorldStaticInfoResponse) {
        final int width = rawWorldStaticInfoResponse.getRealm().getW();
        final int height = rawWorldStaticInfoResponse.getRealm().getH();

        int[] counter = {0};
        final WorldTile[][] tiles = rawWorldStaticInfoResponse.getRealm().getBlock().chars()
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

        return WorldStaticInfoResult.builder()
                .tiles(tiles)
                .build();
    }
}
