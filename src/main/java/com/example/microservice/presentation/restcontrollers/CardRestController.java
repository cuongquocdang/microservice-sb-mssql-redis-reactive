package com.example.microservice.presentation.restcontrollers;

import com.example.microservice.application.dataproviders.CardDataProvider;
import com.example.microservice.domain.Session;
import com.example.microservice.domain.repositories.SessionRepository;
import com.example.microservice.infrastructure.httpclients.card.CardClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cards")
@RequiredArgsConstructor
public class CardRestController {

    private final CardDataProvider cardDataProvider;
    private final SessionRepository sessionRepository;

    @GetMapping
    public List<CardClient.PostDTO> getCards() {
        var session = new Session(String.valueOf(UUID.randomUUID()));
        sessionRepository.storeSession(session).subscribe();
        return List.of(
                cardDataProvider.getCardInfo(1),
                cardDataProvider.getCardInfo(2)
        );
    }
}
