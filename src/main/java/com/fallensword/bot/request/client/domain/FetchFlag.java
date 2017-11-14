package com.fallensword.bot.request.client.domain;

import lombok.Getter;

@Getter
public enum FetchFlag {

    /**
     * Returns information about the player like username, stamina, gold, location etc.
     */
    PLAYER_INFO(1),
    /**
     * Return information about the available actions on the player's location.
     */
    AVAILABLE_ACTIONS(256);

    private final int id;

    FetchFlag(final int id) {
        this.id = id;
    }
}
