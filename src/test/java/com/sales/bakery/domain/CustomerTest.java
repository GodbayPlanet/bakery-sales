package com.sales.bakery.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private static final String CUSTOMER_FIRST_NAME = "Bojana";
	private static final String CUSTOMER_LAST_NAME = "Petric";
	private static final Long CUSTOMER_ID = Long.valueOf(4);
	
	Customer customer;
	
	@Before
	public void setUp() throws Exception {
		customer = new Customer();
	}

	@Test
	public void testGetId() {
		customer.setId(CUSTOMER_ID);
		
		assertEquals(CUSTOMER_ID, customer.getId());
	}
	
	@Test
	public void testGetFirstName() {
		customer.setFirstName(CUSTOMER_FIRST_NAME);
		
		assertEquals(CUSTOMER_FIRST_NAME, customer.getFirstName());
	}
	
	@Test
	public void testLastName() {
		customer.setLastName(CUSTOMER_LAST_NAME);
		
		assertEquals(CUSTOMER_LAST_NAME, customer.getLastName());
	}

}
