package com.akash.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig 
{
	private final ConnectionFactory connectionFactory;
	
	public RabbitMQConfig(ConnectionFactory connectionFactory) {
		super();
		this.connectionFactory = connectionFactory;
	}

	@Bean
	public AmqpTemplate amqpTemplate()
	{
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConvertor());
		return rabbitTemplate;
	}
	
	@Bean
	public MessageConverter messageConvertor()
	{
		MessageConverter jasckson2JsonMessageConverter = new Jackson2JsonMessageConverter();
		return jasckson2JsonMessageConverter;
	}
}
