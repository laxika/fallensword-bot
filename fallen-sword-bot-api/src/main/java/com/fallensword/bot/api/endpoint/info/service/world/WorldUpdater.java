package com.fallensword.bot.api.endpoint.info.service.world;

import com.fallensword.bot.api.domain.world.World;
import com.fallensword.bot.api.endpoint.info.domain.response.world.RealmPartialResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorldUpdater {

    private final TileDataTransformer tileDataTransformer;
    private final DynamicEntryTransformer dynamicEntryTransformer;

    public void updateWorld(final World world, final RealmPartialResponse realmPartialResponse) {
        if (realmPartialResponse == null) {
            return;
        }

        world.setWidth(realmPartialResponse.getW());
        world.setHeight(realmPartialResponse.getH());
        world.setTiles(
                tileDataTransformer.transform(
                        realmPartialResponse.getW(),
                        realmPartialResponse.getH(),
                        realmPartialResponse.getBlock()
                )
        );
        if(realmPartialResponse.getDynamic() != null) {
            world.setDynamicEntries(
                    realmPartialResponse.getDynamic().stream()
                            .map(dynamicEntryTransformer::transform)
                            .collect(Collectors.toList())
            );
        }
    }
}
