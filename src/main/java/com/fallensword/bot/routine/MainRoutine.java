package com.fallensword.bot.routine;

import com.fallensword.bot.request.client.type.world.staticinfo.WorldStaticInfoRequestClient;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.request.WorldStaticInfoRequest;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.response.WorldStaticInfoResponse;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.response.raw.RawWorldStaticInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainRoutine {

    private final WorldStaticInfoRequestClient worldStaticInfoRequestClient;

    public void startBotRoutine() {
        WorldStaticInfoResponse rawWorldStaticInfoResponse = worldStaticInfoRequestClient.request(
                WorldStaticInfoRequest.builder().build()
        );

        System.out.println(rawWorldStaticInfoResponse);
    }
}
