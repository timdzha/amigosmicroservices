package timdev.amigoscode.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationClient {

	@PostMapping("api/v1/notification/{customerId}")
	NotificationResponse notify(
			@PathVariable("customerId") Integer customerId);
}
