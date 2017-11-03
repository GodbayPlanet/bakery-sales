package com.sales.bakery.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

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
import com.sales.bakery.domain.Good;
import com.sales.bakery.domain.Item;
import com.sales.bakery.domain.ItemId;
import com.sales.bakery.domain.Reciept;
import com.sales.bakery.repositories.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BakerySalesApplication.class)
public class ItemServiceImplTest {
	
	private static final int NUMBER_OF_INVOCATIONS = 1;

	private static final int EXPECTED_SIZE_OF_LIST = 1;

	@Mock
	private ItemRepository itemRepository;
	Item item;
	
	private ItemService itemService;
	ItemId itemId = new ItemId(new Reciept(18129L), new Good("70-TU"));

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.itemService = new ItemServiceImpl(itemRepository);
		this.item = new Item();
		item.setItem(itemId);
	}

	@Test
	public void testGetAllItems() {
		List<Item> itemsData = new ArrayList<>();
		itemsData.add(item);
		
		when(itemRepository.findAll()).thenReturn(itemsData);
		
		List<Item> items = itemRepository.findAll();
		
		assertEquals(EXPECTED_SIZE_OF_LIST, items.size());
		verify(itemRepository, times(NUMBER_OF_INVOCATIONS)).findAll();
		
	}

	@Test
	public void testGetByItemId() {
		Optional<Item> itemOptional = Optional.of(item);
		
		when(itemRepository.findById(any())).thenReturn(itemOptional);
		
		Item itemReturned = itemService.getByItemId(itemId);
		
		assertNotNull(itemReturned);
		verify(itemRepository, times(NUMBER_OF_INVOCATIONS)).findById(any());
	}

}
