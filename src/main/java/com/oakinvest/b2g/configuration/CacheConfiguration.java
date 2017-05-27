package com.oakinvest.b2g.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Cache configuration.
 * Created by straumat on 20/05/17.
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    /**
     * Get cache manager.
     * @return cache manager
     */
    @Bean
    @SuppressWarnings("checkstyle:designforextension")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("blockData");
    }

}
