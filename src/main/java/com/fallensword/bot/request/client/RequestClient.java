package com.fallensword.bot.request.client;

import com.fallensword.bot.request.client.domain.Request;
import com.fallensword.bot.request.client.domain.Response;

public interface RequestClient<REQUEST extends Request, RESPONSE extends Response> {

    RESPONSE request(REQUEST request);
}
