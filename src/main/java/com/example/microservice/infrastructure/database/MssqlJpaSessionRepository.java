package com.example.microservice.infrastructure.database;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MssqlJpaSessionRepository extends R2dbcRepository<JpaSessionEntity, Long> {
}
