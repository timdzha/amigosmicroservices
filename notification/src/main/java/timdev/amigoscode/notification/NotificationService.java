package timdev.amigoscode.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import timdev.amigoscode.clients.notification.NotificationRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

	private final NotificationRepository notificationRepository;

	public void send(NotificationRequest notificationRequest) {
		notificationRepository.save(
				Notification.builder()
						.toCustomerId(notificationRequest.toCustomerId())
						.toCustomerEmail(notificationRequest.toCustomerEmail())
						.message(notificationRequest.message())
						.sender(notificationRequest.sender())
						.sentAt(LocalDateTime.now())
						.build());
	}
}
