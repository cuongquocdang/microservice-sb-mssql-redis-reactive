package com.example.microservice.infrastructure.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.spring.webflux.LogbookWebFilter;

@Configuration
public class LogbookConfig {

    /**
     * It is supporting for server request and response logging
     */
    @Bean
    public WebFilter logbookServerFilter(final Logbook logbook) {
        return new LogbookWebFilter(logbook);
    }
}
