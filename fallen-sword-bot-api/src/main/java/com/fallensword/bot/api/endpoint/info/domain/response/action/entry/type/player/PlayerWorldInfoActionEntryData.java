package com.fallensword.bot.api.endpoint.info.domain.response.action.entry.type.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlayerWorldInfoActionEntryData {

    private int id;
    private String name;
    private int level;

    @JsonProperty("guild_id")
    private int guildId;
}
