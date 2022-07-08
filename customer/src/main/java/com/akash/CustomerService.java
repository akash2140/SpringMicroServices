package com.akash;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository repo) {

	public void registerCustomer(CustomerRequest customerRequest) 
	{
		// TODO Auto-generated method stub
		Customer customer=new Customer("Aakash","Singh","akash7500singh@gmail.com");
		repo.save(customer);
	}

}
