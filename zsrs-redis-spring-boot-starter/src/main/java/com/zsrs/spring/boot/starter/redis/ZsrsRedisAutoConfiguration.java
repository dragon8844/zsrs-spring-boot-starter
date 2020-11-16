package com.zsrs.spring.boot.starter.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By IntelliJ IDEA
 *
 * @author LiLong
 * @date 2020/11/16
 */
@Configuration
@ConditionalOnClass(ZsrsRedisProperties.class)
@EnableConfigurationProperties(ZsrsRedisProperties.class)
public class ZsrsRedisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name="jedisTemplete")
    public JedisTemplete jedisTemplete(ZsrsRedisProperties zsrsRedisProperties) {
        JedisTemplete jedisTemplete = new JedisTemplete();

        jedisTemplete.setJedisPool(zsrsRedisProperties.getJedisPool(),zsrsRedisProperties.getPrefix());

        return jedisTemplete;
    }
}
