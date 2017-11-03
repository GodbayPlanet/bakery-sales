package com.sales.bakery.services;

import java.util.List;

import com.sales.bakery.domain.Item;
import com.sales.bakery.domain.ItemId;

public interface ItemService {

	List<Item> getAllItems();
	 
	Item getByItemId(ItemId itemId);
}
