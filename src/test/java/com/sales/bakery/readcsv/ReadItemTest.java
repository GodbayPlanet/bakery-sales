package com.sales.bakery.readcsv;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sales.bakery.domain.Item;

public class ReadItemTest {
	
	private static final int ORDINAL = 1;
	private static final int EXPECTED_SIZE_OF_LIST = 557;
	ReadItem readItem;

	@Before
	public void setUp() throws Exception {
		readItem = new ReadItem();
	}

	@Test
	public void testGetListOfItemsFromCsvFile() {
		List<Item> items = readItem.getListOfItemsFromCsvFile();
		
		assertNotNull(items);
		assertEquals(EXPECTED_SIZE_OF_LIST, items.size());
	}

	@Test
	public void testCreateItem() {
		String[] cells = {"18129", "1", "70-TU"};
		
		Item item = readItem.createItem(cells);
		
		assertNotNull(item);
		assertEquals(ORDINAL, item.getOrdinal());
	}

}
