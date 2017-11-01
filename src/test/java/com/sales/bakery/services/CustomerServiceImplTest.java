package com.sales.bakery.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sales.bakery.BakerySalesApplication;
import com.sales.bakery.domain.Customer;
import com.sales.bakery.repositories.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BakerySalesApplication.class)
public class CustomerServiceImplTest {

	private static final int EXPECTED_SIZE_OF_LIST = 1;
	private static final int NUMBER_OF_INVOCATIONS = 1;
	private static final long CUSTOMER_ID = 5l;

	@Mock
	private CustomerRepository customerRepository;
	
	CustomerServiceImpl customerService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		customerService = new CustomerServiceImpl(customerRepository);
	}

	@Test
	public void testGetAllCutomers() {

		Customer customer = new Customer();
		List<Customer> customerData = new ArrayList<>();
		customerData.add(customer);

		when(customerRepository.findAll()).thenReturn(customerData);

		List<Customer> customers = customerRepository.findAll();

		assertEquals(EXPECTED_SIZE_OF_LIST, customers.size());

		verify(customerRepository, times(NUMBER_OF_INVOCATIONS)).findAll();
		verify(customerRepository, never()).findById(anyLong());

	}

	@Test
	public void testGetById() {
		Customer customer = new Customer();
		customer.setId(CUSTOMER_ID);
		
		Optional<Customer> customerOptional = Optional.of(customer);
		
		when(customerRepository.findById(anyLong())).thenReturn(customerOptional);
		
		Customer customerReturned = customerService.getById(CUSTOMER_ID);
		
		assertNotNull(customerReturned);
		verify(customerRepository, times(NUMBER_OF_INVOCATIONS)).findById(anyLong());
	}
	
}
