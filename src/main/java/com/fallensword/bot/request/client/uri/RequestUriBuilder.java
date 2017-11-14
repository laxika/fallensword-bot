package com.fallensword.bot.request.client.uri;

import org.springframework.stereotype.Service;

@Service
public class RequestUriBuilder {

  public String buildUri(final int action, final int fetchFlag) {
    return "/fetchdata.php?a=" + action + "&d=" + fetchFlag;
  }
}
