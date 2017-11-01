package com.sales.bakery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sales.bakery.domain.Customer;
import com.sales.bakery.exceptions.NotFoundException;
import com.sales.bakery.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		if (!customerOptional.isPresent()) {
			throw new NotFoundException("Customer Not Found. For ID value: "
					+ id.toString());
		}
		
		return customerOptional.get();
	}

}
