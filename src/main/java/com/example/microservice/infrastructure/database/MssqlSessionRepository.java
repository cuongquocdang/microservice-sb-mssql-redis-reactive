package com.example.microservice.infrastructure.database;

import com.example.microservice.domain.Session;
import com.example.microservice.domain.repositories.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MssqlSessionRepository implements SessionRepository {

    private final MssqlJpaSessionRepository mssqlJpaSessionRepository;

    @Override
    public Mono<Session> storeSession(Session session) {
        var entity = new JpaSessionEntity();
        entity.setSessionId(session.sessionId());
        return mssqlJpaSessionRepository.save(entity)
                .map(s -> new Session(s.getId(), s.getSessionId()));
    }
}