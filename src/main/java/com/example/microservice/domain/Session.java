package com.example.microservice.domain;

public record Session(Long id, String sessionId) {

    public Session(String sessionId) {
        this(null, sessionId);
    }
}
