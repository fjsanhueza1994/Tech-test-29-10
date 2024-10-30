package com.tech.test.msmusicsearch.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("itunesCache");
        cacheManager.setCaffeine(Caffeine.newBuilder().maximumSize(100).expireAfterAccess(3600, TimeUnit.SECONDS));
        return cacheManager;
    }
}
