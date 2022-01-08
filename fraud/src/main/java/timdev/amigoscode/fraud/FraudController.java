package timdev.amigoscode.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timdev.amigoscode.clients.fraud.FraudCheckResponse;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

	private final FraudCheckService fraudCheckService;

	@GetMapping(path = "{customerId}")
	public FraudCheckResponse isFraudster(
			@PathVariable ("customerId") Integer customerId) {
		log.info("fraud check request for customer {}", customerId);
		return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
	}
}
