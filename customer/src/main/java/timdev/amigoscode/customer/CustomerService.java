package timdev.amigoscode.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import timdev.amigoscode.clients.fraud.FraudCheckResponse;
import timdev.amigoscode.clients.fraud.FraudClient;

@Service
@AllArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final FraudClient fraudClient;

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

		// todo: send notification
	}
}
