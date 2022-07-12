package com.amigoscode.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
			name = "fraud"
		)
public interface FraudClient 
{
	@PostMapping(path = "api/v1/fraud-check/{customerId}")
	public FraudResponse isFraudulentCustomer(@PathVariable Integer customerId) throws FraudCheckException;
}
