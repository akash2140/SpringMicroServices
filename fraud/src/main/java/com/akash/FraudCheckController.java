package com.akash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudCheckController 
{
	@Autowired
	private FraudCheckService serv;
	
	@PostMapping(path = "/{customerId}")
	public FraudResponse isFraudulentCustomer(@PathVariable Integer customerId) throws FraudCheckException
	{
		Boolean responseResult=serv.isFraudolentCustomer(customerId);
		return new FraudResponse(responseResult);
	}
}
