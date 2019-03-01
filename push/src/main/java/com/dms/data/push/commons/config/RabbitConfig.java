package com.dms.data.push.commons.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitConfig {

	@Value("${spring.rabbitmq.address}")
	private String address;
	@Value("${spring.rabbitmq.username}")
	private String username;
	@Value("${spring.rabbitmq.password}")
	private String password;
	@Value("${spring.rabbitmq.virtual-host}")
	private String vhost;

	@Bean
	ConnectionFactory connectionFactory() {
	    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

	    connectionFactory.setAddresses(address);
	    connectionFactory.setUsername(username);
	    connectionFactory.setPassword(password);
	    connectionFactory.setVirtualHost(vhost);
	    log.info("RabbitMQ连接信息：{}|{}", address, vhost);

	    return connectionFactory;
	}

}
