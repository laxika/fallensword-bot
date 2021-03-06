package com.fallensword.bot.api.domain;

import lombok.Getter;

@Getter
public enum Action {

    /**
     * No specific action to do. Used mostly to fetch information without doing anything else.
     */
    INFO(-1),
    /**
     * Attack a creature on the world map.
     */
    ATTACK_MONSTER(2),
    ATTACK_PLAYER(3),
    /**
     * Move on the world map.
     */
    MOVE(4);

    private final int id;

    Action(final int id) {
        this.id = id;
    }
}
