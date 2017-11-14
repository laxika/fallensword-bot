package com.fallensword.bot.routine;

import com.fallensword.bot.request.client.type.world.staticinfo.WorldStaticInfoRequestClient;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.WorldStaticInfoRequest;
import com.fallensword.bot.request.client.type.world.staticinfo.domain.WorldStaticInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainRoutine {

    private final WorldStaticInfoRequestClient worldStaticInfoRequestClient;

    public void startBotRoutine() {
        WorldStaticInfoResponse worldStaticInfoResponse = worldStaticInfoRequestClient.request(
                WorldStaticInfoRequest.builder().build()
        );

        System.out.println(worldStaticInfoResponse);
    }
}
