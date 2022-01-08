package timdev.amigoscode.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import timdev.amigoscode.clients.notification.NotificationResponse;

@Service
@AllArgsConstructor
public class NotificationService {

	private final NotificationRepository notificationRepository;

	public NotificationResponse notify(Integer customerId) {
		notificationRepository.save(Notification.builder()
				.customerId(customerId)
				.message("")
				.build());
		return new NotificationResponse(customerId, true);
	}
}
