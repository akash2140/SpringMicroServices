package com.akash;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private RestTemplate template;
	
	private static final Log logger=LogFactory.getLog(CustomerService.class);
	public void registerCustomer(CustomerRequest customerRequest) 
	{
		// TODO Auto-generated method stub
		Customer customer=new Customer(customerRequest.firstName(),customerRequest.lastName(),customerRequest.email());
		repo.save(customer);
		logger.info(customer.getId());
		
		//todo Check for fraudster customer
		String fraudUrl="http://localhost:8081/api/v1/fraud-check/{customerId}";
		FraudResponse fraudResponse=template.getForObject(fraudUrl, FraudResponse.class, customer.getId());
		
		logger.info("***FraudResponse***"+fraudResponse.isFraudster());
		
		if(!(fraudResponse == null) && fraudResponse.isFraudster())
			throw new IllegalStateException("Fraudster");
		
	}

}
