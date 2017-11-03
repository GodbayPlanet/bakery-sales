package com.sales.bakery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sales.bakery.domain.Item;
import com.sales.bakery.domain.ItemId;
import com.sales.bakery.exceptions.NotFoundException;
import com.sales.bakery.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item getByItemId(ItemId itemId) {
		Optional<Item> itemOptional = itemRepository.findById(itemId);
		
		if (!itemOptional.isPresent()) {
			throw new NotFoundException("Item with id " + itemId + " not found");
		}
		
		return itemOptional.get();
	}

}
