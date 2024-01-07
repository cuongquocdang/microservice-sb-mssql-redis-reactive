package com.example.microservice.application.dataproviders;

import com.example.microservice.infrastructure.httpclients.card.CardClient;

public interface CardDataProvider {

    CardClient.PostDTO getCardInfo(int id);
}
