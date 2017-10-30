package com.sales.bakery.services;

import java.util.List;

import com.sales.bakery.domain.Customer;

public interface CustomerService {

	 List<Customer> getAllCustomers();
	 
	 Customer getById(Long id);
}
