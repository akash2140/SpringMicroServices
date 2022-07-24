package com.akash;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amigoscode.clients.fraud.FraudCheckException;
import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.fraud.FraudResponse;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.NotificationRequest;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
//	@Autowired
//	private RestTemplate template;
	
//	
	@Autowired
    FraudClient fraudClient ;
	
	@Autowired
	NotificationClient notificationClient;
	
	private static final Log logger=LogFactory.getLog(CustomerService.class);
	public void registerCustomer(CustomerRequest customerRequest) throws FraudCheckException 
	{
		// TODO Auto-generated method stub
		Customer customer=new Customer(customerRequest.firstName(),customerRequest.lastName(),customerRequest.email());
		FraudResponse requestBody=new FraudResponse(true);
		repo.save(customer);
		logger.info(customer.getId());
		
		//todo Check for fraudster customer
		//check how much timr it taske to complete the api request
		long start = System.currentTimeMillis();
		//String fraudUrl="http://localhost:8081/api/v1/fraud-check/{customerId}";
		
		//To communicate with FraudMS using Eureka Server
		//String fraudUrl="http://fraud/api/v1/fraud-check/{customerId}";
	    //FraudResponse fraudResponse=template.getForObject(fraudUrl, FraudResponse.class, customer.getId());
		//FraudResponse fraudResponse=template.postForObject(fraudUrl, requestBody,FraudResponse.class, customer.getId());
		
		//To call FraudApi using Open Feign
		
		FraudResponse fraudResponse=fraudClient.isFraudulentCustomer(customer.getId());
		
		
		long end = System.currentTimeMillis();
		logger.info("Time taken is approximately around"+(end-start));
		logger.info("***FraudResponse***"+fraudResponse.isFraudster());
		
		if(!(fraudResponse == null) && fraudResponse.isFraudster())
			throw new IllegalStateException("Fraudster");
		
		
		//Todo To make it async , add it to queue
		NotificationRequest notificationRequestObject=new NotificationRequest(customer.getId(),
																				customer.getEmail(),
																				String.format("Hi %s, welcome to Amigoscode", customer.getFirstName())
																				);
		logger.info("Calling notification Service From Customer");
		
		notificationClient.sendNotification(
					notificationRequestObject
				);
		logger.info("notification Sent without Failure From Customer");
	}

}
