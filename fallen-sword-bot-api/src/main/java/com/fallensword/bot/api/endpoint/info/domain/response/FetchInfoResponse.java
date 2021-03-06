package com.fallensword.bot.api.endpoint.info.domain.response;

import com.fallensword.bot.api.endpoint.info.domain.response.action.entry.WorldInfoActionEntry;
import com.fallensword.bot.api.endpoint.info.domain.response.player.PlayerPartialResponse;
import com.fallensword.bot.api.endpoint.info.domain.response.world.RealmPartialResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FetchInfoResponse {

    private final PlayerPartialResponse player;
    private final RealmPartialResponse realm;
    private final List<WorldInfoActionEntry> actions;
}
