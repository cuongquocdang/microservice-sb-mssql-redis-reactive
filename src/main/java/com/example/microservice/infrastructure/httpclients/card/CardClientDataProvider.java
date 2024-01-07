package com.example.microservice.infrastructure.httpclients.card;

import com.example.microservice.application.dataproviders.CardDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardClientDataProvider implements CardDataProvider {

    private final CardClient cardClient;

    @Cacheable(cacheNames = "CARD_INFO", key = "#id")
    @Override
    public CardClient.PostDTO getCardInfo(final int id) {
        return cardClient.fetchPostById(id);
    }
}
