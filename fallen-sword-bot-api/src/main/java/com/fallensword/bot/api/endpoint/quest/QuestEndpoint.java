package com.fallensword.bot.api.endpoint.quest;

import com.fallensword.bot.api.RequestResolver;
import com.fallensword.bot.api.domain.Action;
import com.fallensword.bot.api.domain.Endpoint;
import com.fallensword.bot.api.domain.FetchFlag;
import com.fallensword.bot.api.endpoint.quest.domain.QuestContext;
import com.fallensword.bot.api.endpoint.quest.domain.QuestResult;
import com.fallensword.bot.api.endpoint.quest.domain.response.QuestResponse;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestEndpoint implements Endpoint<QuestContext, QuestResult> {

    private final RequestResolver requestResolver;

    @Override
    public QuestResult request(QuestContext context) {
        log.info("Accepting/updating quest: " + context.getQuestId());

        requestResolver.executeRequest(Action.QUEST, FetchFlag.NONE,
                buildRequestParameters(context), QuestResponse.class);

        return QuestResult.builder()
                .build();
    }

    private Map<String, String> buildRequestParameters(final QuestContext context) {
        return ImmutableMap.of(
                "id", String.valueOf(context.getQuestId())
        );
    }
}
