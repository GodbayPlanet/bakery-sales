package com.sales.bakery.readcsv;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sales.bakery.domain.Good;

public class ReadGoodTest {
	
	private static final int EXPECTED_LIST_SIZE = 40;
	ReadGood readGood;
	
	@Before
	public void setUp() throws Exception {
		readGood = new ReadGood();
	}

	@Test
	public void testGetListOfGoodsFromCsvFile() {
		
		List<Good> goods = readGood.getListOfGoodsFromCsvFile();
		
		assertNotNull(goods);
		assertEquals(EXPECTED_LIST_SIZE, goods.size());
	}

	@Test
	public void testCreateGood() {
		String[] cells = {"45-CO", "Chocolate", "Cake", "8.95"};
		
		Good good = readGood.createGood(cells);
		
		assertNotNull(good);
		assertEquals("45-CO", good.getId());
	}
}
