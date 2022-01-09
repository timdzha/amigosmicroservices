package timdev.amigoscode.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notification {

	@Id
	@SequenceGenerator(
			name = "notification_id_sequence",
			sequenceName = "notification_id_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "notification_id_sequence"
	)
	private Integer id;
	private String sender;
	private Integer toCustomerId;
	private String toCustomerEmail;
	private String message;
	private LocalDateTime sentAt;
}
