package com.fallensword.bot.api;

import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.FetchFlag;
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
        return executeRequest(action, fetchFlag.getId(), Collections.emptyMap(), type);
    }

    public <T> T executeRequest(final Action action, final FetchFlag fetchFlag, Map<String, String> parameters, Class<T> type) {
        return executeRequest(action, fetchFlag.getId(), parameters, type);
    }

    public <T> T executeRequest(final Action action, final int fetchFlag, Class<T> type) {
        return executeRequest(action, fetchFlag, Collections.emptyMap(), type);
    }

    public <T> T executeRequest(final Action action, final int fetchFlag, Map<String, String> parameters, Class<T> type) {
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
