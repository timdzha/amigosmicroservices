package timdev.amigoscode.clients.notification;

public record NotificationRequest(
	String sender,
	Integer toCustomerId,
	String toCustomerEmail,
	String message) {

}
