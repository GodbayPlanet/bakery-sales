package com.sales.bakery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.bakery.domain.Customer;
import com.sales.bakery.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		return customerOptional.get();
	}

}
