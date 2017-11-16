package com.fallensword.bot.api.domain.player;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class Player {

    private int locationX;
    private int locationY;
    private int currentStamina;
    private int maximumStamina;
}
