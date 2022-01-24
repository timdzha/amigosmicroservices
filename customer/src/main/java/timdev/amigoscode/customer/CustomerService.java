package timdev.amigoscode.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import timdev.amigoscode.amqp.RabbitMqMessageProducer;
import timdev.amigoscode.clients.fraud.FraudCheckResponse;
import timdev.amigoscode.clients.fraud.FraudClient;
import timdev.amigoscode.clients.notification.NotificationRequest;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final FraudClient fraudClient;
	private final RabbitMqMessageProducer rabbitMqMessageProducer;

	public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
		final Customer customer = Customer.builder()
				.firstName(customerRegistrationRequest.firstName())
				.lastName(customerRegistrationRequest.lastName())
				.email(customerRegistrationRequest.email())
				.build();

		// todo: check if email valid
		// todo: check if email not taken

		// we need to saveAndFlush to get a customerId
		customerRepository.saveAndFlush(customer);

		final FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
		if (fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("fraudster");
		}

		final NotificationRequest notificationRequest = new NotificationRequest(
				customer.getFirstName(),
				customer.getId(),
				customer.getEmail(),
				"Hello");

		rabbitMqMessageProducer.publish(
				notificationRequest,
				"internal.exchange",
				"internal.notification.routing-key");
	}
}
