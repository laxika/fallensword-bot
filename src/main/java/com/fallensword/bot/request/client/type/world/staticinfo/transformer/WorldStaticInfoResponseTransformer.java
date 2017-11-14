package com.fallensword.bot.request.client.type.world.staticinfo.transformer;

import com.fallensword.bot.request.client.type.world.staticinfo.domain.response.WorldStaticInfoResponse;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.response.domain.WorldTile;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.response.raw.RawWorldStaticInfoResponse;
import org.springframework.stereotype.Service;

@Service
public class WorldStaticInfoResponseTransformer {

    private static char NON_WALKABLE_TILE_ID = '0';

    public WorldStaticInfoResponse transform(final RawWorldStaticInfoResponse rawWorldStaticInfoResponse) {
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

        return WorldStaticInfoResponse.builder()
                .tiles(tiles)
                .build();
    }
}
