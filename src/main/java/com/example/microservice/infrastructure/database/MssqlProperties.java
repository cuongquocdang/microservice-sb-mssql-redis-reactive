package com.example.microservice.infrastructure.database;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "db.mssql")
@Data
public class MssqlProperties {

    private int port;

    private String host;
    private String username;
    private String password;
    private String databaseName;
}
