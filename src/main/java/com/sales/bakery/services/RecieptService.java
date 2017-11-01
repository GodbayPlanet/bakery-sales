package com.sales.bakery.services;

import java.util.List;

import com.sales.bakery.domain.Reciept;

public interface RecieptService {
	
	List<Reciept> getAllReciepts();
	 
	Reciept getByRecieptNumber(Long recieptNumber);
}
