package com.fallensword.bot.api.domain;

import lombok.Getter;

@Getter
public enum FetchFlag {

    /**
     * A flag for no/empty result.
     */
    NONE(0),
    /**
     * Return information about the player like username, currentStamina, gold, location etc.
     */
    PLAYER_INFO(1),
    /**
     * Return the static information of the world.
     */
    STATIC_WORLD_INFO(64),
    /**
     * Return the dynamic information of the world. Like available quests, open/closed endpoints etc.
     */
    DYNAMIC_WORLD_INFO(128),
    /**
     * Return information about the available actions on the player's location.
     */
    AVAILABLE_ACTIONS(256);

    private final int id;

    FetchFlag(final int id) {
        this.id = id;
    }
}
