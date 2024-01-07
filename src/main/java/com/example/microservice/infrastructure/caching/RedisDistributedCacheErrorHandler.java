package com.example.microservice.infrastructure.caching;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

@Slf4j
@SuppressWarnings("all")
public class RedisDistributedCacheErrorHandler implements CacheErrorHandler {

    @Override
    public void handleCacheGetError(final RuntimeException exception, final Cache cache, final Object key) {
        log.error("[redis-distributed-cache] cache get error message: {}", exception.getMessage());
    }

    @Override
    public void handleCachePutError(final RuntimeException exception, final Cache cache, final Object key, final Object value) {
        log.error("[redis-distributed-cache] cache put error message: {}", exception.getMessage());
    }

    @Override
    public void handleCacheEvictError(final RuntimeException exception, final Cache cache, final Object key) {
        log.error("[redis-distributed-cache] cache evict error message: {}", exception.getMessage());
    }

    @Override
    public void handleCacheClearError(final RuntimeException exception, final Cache cache) {
        log.error("[redis-distributed-cache] cache clear error message: {}", exception.getMessage());
    }
}
