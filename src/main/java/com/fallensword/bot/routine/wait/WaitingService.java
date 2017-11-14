package com.fallensword.bot.routine.wait;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class WaitingService {

    private static final Random RANDOM = new Random();

    public void randomWait(final int milliseconds) {
        final int max = (int) Math.round(milliseconds * 1.40);
        final int min = (int) Math.round(milliseconds * 0.6);
        final int waitingTime = RANDOM.nextInt(max + 1 - min) + min;

        log.info("Waiting for " + waitingTime + " milliseconds.");

        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
