package com.fallensword.bot.command;

import com.fallensword.bot.request.client.type.info.PlayerInfoRequestClient;
import com.fallensword.bot.request.client.type.info.domain.PlayerInfoRequest;
import com.fallensword.bot.request.client.type.info.domain.PlayerInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BotApplicationRunner implements ApplicationRunner {

  private final PlayerInfoRequestClient playerInfoRequestClient;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    final PlayerInfoResponse playerInfoResponse = playerInfoRequestClient.request(
        PlayerInfoRequest.builder()
            .build()
    );

    System.out.println(playerInfoResponse.getPlayer().getUsername());
  }
}
