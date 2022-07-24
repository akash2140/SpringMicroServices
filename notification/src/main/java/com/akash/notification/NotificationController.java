package com.akash.notification;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amigoscode.clients.notification.NotificationRequest;

@RestController
public class NotificationController 
{
	@Autowired
	private NotificationService notificationService;
	
	private static final Log logger=LogFactory.getLog(NotificationController.class);
	
	@PostMapping("api/v1/notification")
	public void sendNotification(@RequestBody NotificationRequest request)
	{
		logger.info("Sending Notification Starting...."+request);
		notificationService.sendNotification(request);
		logger.info("Notification Sent..."+request);
		
	}
	
}
