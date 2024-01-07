package com.example.microservice.infrastructure.httpclients;

import com.example.microservice.infrastructure.httpclients.card.CardClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.spring.webflux.LogbookExchangeFilterFunction;

@Configuration
public class HttpClientConfig {

    @Bean
    public CardClient cardClient(final WebClient.Builder webClientBuilder, final Logbook logbook) {

        var webClient = webClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .filter(new LogbookExchangeFilterFunction(logbook))
                .build();

        var httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient))
                        .build();

        return httpServiceProxyFactory.createClient(CardClient.class);
    }
}
