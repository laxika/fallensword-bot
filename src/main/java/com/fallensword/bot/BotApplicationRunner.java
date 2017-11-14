package com.fallensword.bot;

import com.fallensword.bot.request.client.type.world.WorldInfoRequestClient;
import com.fallensword.bot.request.client.type.world.domain.WorldInfoRequest;
import com.fallensword.bot.request.client.type.world.domain.WorldInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BotApplicationRunner implements ApplicationRunner {

    private final WorldInfoRequestClient worldInfoRequestClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final WorldInfoResponse worldInfoResponse = worldInfoRequestClient.request(
                WorldInfoRequest.builder()
                        .build()
        );

        System.out.println(worldInfoResponse.getActions());
    }
}
