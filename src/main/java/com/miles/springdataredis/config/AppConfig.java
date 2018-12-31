/*
package com.miles.springdataredis.config;

import com.miles.springdataredis.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class AppConfig {
    private @Value("${spring.redis.host}") String redisHost;
    private @Value("${spring.redis.port}") int redisPort;

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(redisHost);
		factory.setPort(redisPort);
		factory.setUsePool(true);
		return factory;
	}

	@Bean
	RedisTemplate<String, String> redisTemplate(){
		RedisTemplate<String, String> template = new RedisTemplate<>();
		//template.setKeySerializer(new StringRedisSerializer());
		template.setDefaultSerializer(new StringRedisSerializer());
		//template.setHashKeySerializer(new StringRedisSerializer());
		//template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

}
*/
