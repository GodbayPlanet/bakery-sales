package com.sales.bakery.readcsv;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sales.bakery.domain.Reciept;

public class ReadRecieptTest {

	private static final Long RECIEPT_NUMBER = 1L;
	ReadReciept readReciept;

	@Before
	public void setUp() throws Exception {
		readReciept = new ReadReciept();
	}

	@Test
	public void testGetListOfReceiptsFromCsvFile() {
		
		List<Reciept> receipts = readReciept.getListOfReceiptsFromCsvFile();
		
		assertNotNull(receipts);
		assertEquals(200, receipts.size());
	}
	
	@Test
	public void testCreateReciept() {
		String[] cells = {"1", "28-Oct-2007", "15"};
		
		Reciept reciept = readReciept.createReciept(cells);
		
		assertNotNull(reciept);
		assertEquals(RECIEPT_NUMBER, reciept.getRecieptNumber());
	}

}
