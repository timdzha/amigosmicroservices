package timdev.amigoscode.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@AllArgsConstructor
public class RabbitMqConfig {

	private final ConnectionFactory connectionFactory;

	/**
	 * amqpTemplate to send message to the queue
	 * @return
	 */
	@Bean
	public AmqpTemplate amqpTemplate() {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jacksonConverter());
		return rabbitTemplate;
	}

	/**
	 * listener to receive message from the queue
	 * @return
	 */
	@Bean
	public SimpleRabbitListenerContainerFactory factory() {
		final SimpleRabbitListenerContainerFactory factory
				= new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(jacksonConverter());
		return factory;
	}

	/**
	 * json message converter
	 * we can use {@link Jackson2ObjectMapperBuilder#xml()} to convert json to xml
	 * we can use {@link Jackson2ObjectMapperBuilder#json()} to convert json to json
	 * @return
	 */
	@Bean
	public MessageConverter jacksonConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
