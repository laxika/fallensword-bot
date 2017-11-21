package com.fallensword.bot.api.endpoint.info.service.action;

import com.fallensword.bot.world.domain.World;
import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.WorldInfoActionEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionUpdater {

    private final ActionTransformer actionTransformer;

    public void updateActions(final World world, final List<WorldInfoActionEntry> actions) {
        world.setAvailableActions(actionTransformer.transform(actions));
    }
}
