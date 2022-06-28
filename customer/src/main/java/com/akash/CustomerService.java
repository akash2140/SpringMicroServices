package com.akash;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public record CustomerService() {

	public void registerCustomer(CustomerRequest request) {
		// TODO Auto-generated method stub
		  Customer customer = new Customer(request.firstname(),request.lastName(),request.email());
		  
		  
	}

}
