package com.akash;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.web.client.UnorderedRequestExpectationManager;

import com.amigoscode.clients.fraud.FraudCheckException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService 
{
	@Autowired
	private  FraudCheckHistoryRepository repo ;
	
	public  Boolean isFraudolentCustomer(Integer customerId) throws FraudCheckException
	{
//		Optional<FraudCheckHistory> fraudCheck=repo.findById(customerId);
//		fraudCheck.orElseThrow(() -> new FraudCheckException("CUSTOMER-NOT_FOUND"));
		
		FraudCheckHistory hist=new FraudCheckHistory(customerId,false,LocalDateTime.now());
		repo.save(hist);
		return false;
	
	}
	
}
