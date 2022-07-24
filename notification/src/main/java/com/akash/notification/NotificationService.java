package com.akash.notification;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import com.amigoscode.clients.notification.NotificationRequest;
@Service
@NoArgsConstructor
public class NotificationService 
{
	@Autowired
	private NotificationRepository notificationRepo;
	
	private static final Log log=LogFactory.getLog(NotificationService.class);
	
	public void sendNotification(NotificationRequest request)
	{	
		log.info("Sending Notification... {}"+ request);
		notificationRepo.save(
					new Notification(
							request.toCustomerId(),
							request.toCustomerEmail(),
							"amigoscode",
							request.message(),
							LocalDateTime.now()
							)
				);
	}
	
}
