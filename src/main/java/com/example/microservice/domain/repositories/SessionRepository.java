package com.example.microservice.domain.repositories;

import com.example.microservice.domain.Session;
import reactor.core.publisher.Mono;

public interface SessionRepository {

    Mono<Session> storeSession(Session session);
}
