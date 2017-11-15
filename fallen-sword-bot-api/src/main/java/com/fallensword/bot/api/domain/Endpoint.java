package com.fallensword.bot.api.domain;

import com.fallensword.bot.api.domain.Context;
import com.fallensword.bot.api.domain.Result;

public interface Endpoint<CONTEXT extends Context, RESULT extends Result> {

    RESULT request(CONTEXT CONTEXT);
}
