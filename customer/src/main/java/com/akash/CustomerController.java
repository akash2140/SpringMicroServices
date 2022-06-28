package com.akash;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService serv)
{
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CustomerController.class);

	@PostMapping
	public void registerCustomer(@RequestBody CustomerRequest customerRequest)
	{
		log.info("Customer for registration {}"+customerRequest);
		serv.registerCustomer(customerRequest);
	}
}
