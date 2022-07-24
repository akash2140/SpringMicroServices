package com.akash.notification;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification 
{
	@Id
	@SequenceGenerator(
			name = "notification_id_sequence",
			sequenceName = "notification_id_sequence"
			)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "notification_id_sequence"
			)
	private Integer notificationId;
	private Integer customerId;
	private String toCustomerEmail;
	private String sender;
	private String message;
	private LocalDateTime sentAt;
	
	
	public Notification(Integer customerId, String toCustomerEmail, String sender, String message,
			LocalDateTime sentAt) {
		super();
		this.customerId = customerId;
		this.toCustomerEmail = toCustomerEmail;
		this.sender = sender;
		this.message = message;
		this.sentAt = sentAt;
	}

	public Integer getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getToCustomerEmail() {
		return toCustomerEmail;
	}
	public void setToCustomerEmail(String toCustomerEmail) {
		this.toCustomerEmail = toCustomerEmail;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getSentAt() {
		return sentAt;
	}
	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", customerId=" + customerId + ", toCustomerEmail="
				+ toCustomerEmail + ", sender=" + sender + ", message=" + message + ", sentAt=" + sentAt + "]";
	}
	
	
	
}
