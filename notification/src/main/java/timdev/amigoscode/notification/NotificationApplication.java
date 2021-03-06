package timdev.amigoscode.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication (
		scanBasePackages = {
				"timdev.amigoscode.notification",
				"timdev.amigoscode.amqp"
		}
)
@EnableEurekaClient
public class NotificationApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(
//			RabbitMqMessageProducer producer,
//			NotificationConfig notificationConfig) {
//		return args -> {
//			producer.publish(
//					new Person("user", 28),
//					notificationConfig.getInternalExchange(),
//					notificationConfig.getInternalNotificationRoutingKey());
//		};
//	}
//
//	record Person(String name, int age) {}
}
