package com.fallensword.bot.request.client.domain;

import lombok.Getter;

@Getter
public enum Action {

    /**
     * No specific action to do. Used mostly to fetch information without doing anything else.
     */
    INFO(-1);

    private final int id;

    Action(final int id) {
        this.id = id;
    }
}
