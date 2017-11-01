package com.sales.bakery.bootstrap;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sales.bakery.domain.Customer;
import com.sales.bakery.readcsv.ReadCustomer;
import com.sales.bakery.repositories.CustomerRepository;

@Slf4j
@Component
public class CustomerBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CustomerRepository customerRepository;
	
	public CustomerBootstrap(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<Customer> customers = ReadCustomer.getListOfCustomersFormCsvFile();
		customerRepository.saveAll(customers);
		log.debug("Loading Bootstrap Data");
	}
	
}
