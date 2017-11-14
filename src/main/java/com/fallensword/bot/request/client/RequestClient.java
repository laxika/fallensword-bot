package com.fallensword.bot.request.client;

public interface RequestClient<REQUEST extends Request, RESPONSE extends Response> {

    RESPONSE request(REQUEST request);
}
