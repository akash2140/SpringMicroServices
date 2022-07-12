package com.akash;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoscode.clients.fraud.FraudCheckException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService serv)
{
	
	private static final Log logger=LogFactory.getLog(CustomerController.class);
	@PostMapping
	public void registerCustomer(@RequestBody CustomerRequest customerRequest)throws FraudCheckException
	{
			logger.info("Customer Reuqets objext is "+customerRequest);
			serv.registerCustomer(customerRequest);
	}
	
}
