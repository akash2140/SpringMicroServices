package com.amigoscode.clients.notification;

public record NotificationRequest(Integer toCustomerId,
        String toCustomerEmail,
        String message) {

	public Integer toCustomerId() {
		return toCustomerId;
	}

	public String toCustomerEmail() {
		return toCustomerEmail;
	}

	public String message() {
		return message;
	}

	@Override
	public String toString() {
		return "NotificationRequest [toCustomerId=" + toCustomerId + ", toCustomerEmail=" + toCustomerEmail
				+ ", message=" + message + "]";
	}
	
}
