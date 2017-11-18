package com.fallensword.bot.movement;

import com.fallensword.bot.api.domain.player.Player;
import com.fallensword.bot.api.domain.world.World;
import com.fallensword.bot.api.domain.world.tile.WorldTile;
import com.fallensword.bot.api.endpoint.movement.MovementEndpoint;
import com.fallensword.bot.api.endpoint.movement.domain.MovementContext;
import com.fallensword.bot.movement.target.MovementTargetCalculator;
import com.fallensword.bot.movement.target.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementEndpoint movementEndpoint;
    private final MovementTargetCalculator movementTargetCalculator;

    public void moveToNextDirection(final Player player, final World world) {
        final Location location = movementTargetCalculator.calculateNextTarget(player, world);

        moveTo(location.getX(), location.getY(), player, world);
    }

    public void moveTo(final int targetX, final int targetY, final Player player, final World world) {
        final WorldTile targetTile = world.getTileAt(targetX, targetY);
        targetTile.setMovementCount(targetTile.getMovementCount() + 1);

        movementEndpoint.request(
                MovementContext.builder()
                        .player(player)
                        .targetX(targetX)
                        .targetY(targetY)
                        .build()
        );
    }
}
