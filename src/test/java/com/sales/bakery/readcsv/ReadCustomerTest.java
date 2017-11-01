package com.sales.bakery.readcsv;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.sales.bakery.domain.Customer;

@RunWith(SpringRunner.class)
public class ReadCustomerTest {

	private static final int LIST_SIZE = 20;
	private static final Long CUSTOMER_ID = 1L;
	
	ReadCustomer readCustomer;
	
	@Before
	public void setUp() throws Exception {
		readCustomer = new ReadCustomer();
	}

	@Test
	public void testGetListOfCustomersFormCsvFile() {
		
		List<Customer> customers = readCustomer.getListOfCustomersFormCsvFile();
		
		assertEquals(LIST_SIZE, customers.size());
	}
	
	@Test
	public void testCreateCustomer() {
		String[] cells = {"1", "Pero", "Peric"};
		
		Customer customer = readCustomer.createCustomer(cells);
		
		assertNotNull(customer);
		assertEquals(CUSTOMER_ID, customer.getId());
	}

}
