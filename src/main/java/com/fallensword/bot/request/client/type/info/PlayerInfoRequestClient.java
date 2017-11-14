package com.fallensword.bot.request.client.type.info;

import com.fallensword.bot.request.client.RequestClient;
import com.fallensword.bot.request.client.RequestResolver;
import com.fallensword.bot.request.client.type.info.domain.PlayerInfoRequest;
import com.fallensword.bot.request.client.type.info.domain.PlayerInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerInfoRequestClient implements
    RequestClient<PlayerInfoRequest, PlayerInfoResponse> {

  private final static int INFO_REQUEST_ACTION_ID = -1;
  private final static int INFO_REQUEST_FETCH_FLAG = 1;

  private final RequestResolver requestResolver;

  @Override
  public PlayerInfoResponse request(PlayerInfoRequest request) {
    return requestResolver
        .executeRequest(INFO_REQUEST_ACTION_ID, INFO_REQUEST_FETCH_FLAG, PlayerInfoResponse.class);
  }
}
