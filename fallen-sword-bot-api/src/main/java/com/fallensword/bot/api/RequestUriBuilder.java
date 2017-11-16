package com.fallensword.bot.api;

import com.fallensword.bot.api.domain.Action;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RequestUriBuilder {

    public String buildUri(final Action action, final int fetchFlag, final Map<String, String> parameters) {
        return "/fetchdata.php?a=" + action.getId() + "&d=" + fetchFlag + buildParameters(parameters);
    }

    private String buildParameters(final Map<String, String> parameters) {
        if (parameters.size() == 0) {
            return "";
        }

        return "&" + parameters.entrySet().stream()
                .map(stringStringEntry -> stringStringEntry.getKey() + "=" + stringStringEntry.getValue())
                .collect(Collectors.joining("&"));
    }
}
