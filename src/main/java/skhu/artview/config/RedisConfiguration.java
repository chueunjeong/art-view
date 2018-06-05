/*package skhu.artview.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfiguration {

	@Value("${spring.redis.host}")
	private String redisHostName;

	@Value("${spring.redis.port}")
	private int redisPort;

	@Value("${spring.redis.password}")
	private String redisPassword;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(redisHostName);
		factory.setPort(redisPort);
		factory.setPassword(redisPassword);
		factory.setUsePool(true);
		//factory.afterPropertiesSet();
		return factory;
	}

	@Bean
	public StringRedisTemplate redisTemplate() {
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	@Bean
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
		return redisCacheManager;
	}
}*/