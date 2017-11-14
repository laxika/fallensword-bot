package com.fallensword.bot.request.client;

import com.fallensword.bot.request.client.domain.Action;
import com.fallensword.bot.request.client.domain.FetchFlag;
import com.fallensword.bot.request.client.uri.RequestUriBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequestResolver {

    private final WebClient webClient;
    private final RequestUriBuilder requestUriBuilder;
    private final ObjectMapper objectMapper;

    public <T> T executeRequest(final Action action, final FetchFlag fetchFlag, Class<T> type) {
        return executeRequest(action, fetchFlag, Collections.emptyMap(), type);
    }

    public <T> T executeRequest(final Action action, final FetchFlag fetchFlag, Map<String, String> parameters, Class<T> type) {
        final String infoUri = requestUriBuilder
                .buildUri(action, fetchFlag, parameters);

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
