package com.fallensword.bot.api.endpoint.info.service.player;

import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.endpoint.info.domain.response.player.PlayerPartialResponse;
import org.springframework.stereotype.Service;

@Service
public class PlayerUpdater {

    public void updatePlayer(final Player player, final PlayerPartialResponse playerPartialResponse) {
        if (playerPartialResponse == null) {
            return;
        }

        player.setCurrentStamina(playerPartialResponse.getStamina().getCurrent());
        player.setMaximumStamina(playerPartialResponse.getStamina().getMaximum());
    }
}
