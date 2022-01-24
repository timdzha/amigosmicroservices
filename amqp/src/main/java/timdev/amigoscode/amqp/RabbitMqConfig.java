package timdev.amigoscode.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabbitMqConfig {

	private final ConnectionFactory connectionFactory;

	@Bean
	public AmqpTemplate amqpTemplate() {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jacksonConverter());
		return rabbitTemplate;
	}

	@Bean
	public MessageConverter jacksonConverter() {
//		Jackson2ObjectMapperBuilder.json();
//		Jackson2ObjectMapperBuilder.xml();
		return new Jackson2JsonMessageConverter();
	}
}
