package com.example.microservice.infrastructure.httpclients.card;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface CardClient {

    @GetExchange("/posts/{id}")
    PostDTO fetchPostById(@PathVariable int id);

    record PostDTO(String title, String body) {
    }
}