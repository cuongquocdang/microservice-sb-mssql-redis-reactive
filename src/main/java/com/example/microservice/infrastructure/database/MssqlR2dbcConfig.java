package com.example.microservice.infrastructure.database;

import io.r2dbc.mssql.MssqlConnectionConfiguration;
import io.r2dbc.mssql.MssqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

@Configuration
@RequiredArgsConstructor
public class MssqlR2dbcConfig extends AbstractR2dbcConfiguration {

    private final MssqlProperties mssqlProperties;

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        return new MssqlConnectionFactory(
                MssqlConnectionConfiguration.builder()
                        .host(mssqlProperties.getHost())
                        .port(mssqlProperties.getPort())
                        .username(mssqlProperties.getUsername())
                        .password(mssqlProperties.getPassword())
                        .database(mssqlProperties.getDatabaseName())
                        .trustServerCertificate()
                        .build());
    }
}
