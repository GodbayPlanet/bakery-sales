package com.sales.bakery.readcsv;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.sales.bakery.domain.Customer;

@RunWith(SpringRunner.class)
public class ReadCustomerTest {

	ReadCustomer readCustomer;
	
	@Before
	public void setUp() throws Exception {
		readCustomer = new ReadCustomer();
	}

	@Test
	public void testGetListOfCustomersFormCsvFile() {
		
		List<Customer> customers = readCustomer.getListOfCustomersFormCsvFile();
		
		assertEquals(20, customers.size());
	}

}
