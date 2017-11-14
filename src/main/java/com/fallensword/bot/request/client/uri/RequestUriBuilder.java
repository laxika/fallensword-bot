package com.fallensword.bot.request.client.uri;

import com.fallensword.bot.request.client.domain.Action;
import com.fallensword.bot.request.client.domain.FetchFlag;
import org.springframework.stereotype.Service;

@Service
public class RequestUriBuilder {

    public String buildUri(final Action action, final FetchFlag fetchFlag) {
        return "/fetchdata.php?a=" + action.getId() + "&d=" + fetchFlag.getId();
    }
}
