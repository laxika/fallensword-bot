package com.fallensword.bot.routine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * This service makes the requests done by the but more human like by adding delays between request simulating a human.
 */
@Slf4j
@Service
public class WaitingService {

    private static final Random RANDOM = new Random();

    /**
     * Delay the execution of this thread by a given amount of milliseconds. The actual delay time is slightly altered
     * and randomized to make it more human like.
     *
     * @param milliseconds how long should the bot wait before continue execution
     */
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
