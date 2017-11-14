package com.fallensword.bot.request;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RequestConfiguration {

  @Bean
  public WebClient botClient() {
    return WebClient.builder()
        .baseUrl("https://www.fallensword.com/")
        .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36")
        .defaultHeader(HttpHeaders.HOST, "www.fallensword.com")
        .defaultHeader(HttpHeaders.COOKIE, "fsId=152146; fsSessionKey=BRWsO9gpY4kpYY5YMxzkHjZ1WaONcUqt;")
        .defaultHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.9")
        .build();
  }
}
