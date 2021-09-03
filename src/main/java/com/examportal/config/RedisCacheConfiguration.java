package com.examportal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisCacheConfiguration {

	
	  @Bean 
	  public JedisConnectionFactory getJedisConnectionFactory() {
	  
	  RedisStandaloneConfiguration config=new RedisStandaloneConfiguration();
	  
	  config.setHostName("localhost"); config.setPort(6379); JedisConnectionFactory
	  jedisFactory=new JedisConnectionFactory(config);
	  
	  return jedisFactory;
	  
	  
	/*
	 *  if Reddis server present in different machine, this configuration required.
		jedisFactory.setHostName(hostName); jedisFactory.setPassword(password);
	  	jedisFactory.setPort(6379);
	   */

	  
	  }
	  
	  @Bean 
	  public RedisTemplate<String, Object> getRedisTemplate() {
	  
	  RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
	  redisTemplate.setConnectionFactory(getJedisConnectionFactory());
	  
	  redisTemplate.setKeySerializer(new StringRedisSerializer());
	  redisTemplate.setHashKeySerializer(new StringRedisSerializer());
	  redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
	  redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
	  redisTemplate.setEnableTransactionSupport(true);
	  redisTemplate.afterPropertiesSet();
	  
	  return redisTemplate; }
	 

}
