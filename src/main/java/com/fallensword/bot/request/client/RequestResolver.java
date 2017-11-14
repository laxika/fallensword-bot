package com.fallensword.bot.request.client;

import com.fallensword.bot.request.client.uri.RequestUriBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class RequestResolver {

  private final WebClient webClient;
  private final RequestUriBuilder requestUriBuilder;
  private final ObjectMapper objectMapper;

  public <T> T executeRequest(int actionId, int fetchId, Class<T> type) {
    final String infoUri = requestUriBuilder
        .buildUri(actionId, fetchId);

    final String content = webClient.get()
        .uri(infoUri)
        .retrieve()
        .bodyToMono(String.class)
        .block();

    try {
      return objectMapper.readValue(content, type);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
