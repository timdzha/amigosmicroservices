package timdev.amigoscode.notification;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timdev.amigoscode.clients.notification.NotificationResponse;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

	private final NotificationService notificationService;

	@PostMapping("{customerId}")
	public NotificationResponse notify(
			@PathVariable("customerId") Integer customerId) {
		return notificationService.notify(customerId);
	}
}
