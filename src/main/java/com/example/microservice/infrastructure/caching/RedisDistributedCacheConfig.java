package com.example.microservice.infrastructure.caching;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class RedisDistributedCacheConfig implements CachingConfigurer {

    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
        return new RedisDistributedCacheErrorHandler();
    }

    @Bean
    public CacheManager cacheManager(final RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(createCacheConfiguration(7200L)) // 2h
                .withInitialCacheConfigurations(
                        createCustomCacheConfigurations(Map.of("CARD_INFO", 3600L)))
                .build();
    }

    private static Map<String, RedisCacheConfiguration> createCustomCacheConfigurations(
            final Map<String, Long> specificCacheExpirations) {
        if (null == specificCacheExpirations) {
            return Map.of();
        }
        return specificCacheExpirations.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> createCacheConfiguration(e.getValue())));
    }

    private static RedisCacheConfiguration createCacheConfiguration(final long timeoutInSeconds) {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(timeoutInSeconds))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
}
