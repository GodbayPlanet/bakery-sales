package com.sales.bakery.bootstrap;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sales.bakery.domain.Item;
import com.sales.bakery.readcsv.ReadItem;
import com.sales.bakery.repositories.ItemRepository;

@Slf4j
@Component
public class ItemBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private final ItemRepository itemRepository;
	private final ReadItem readItem;
	
	public ItemBootstrap(ItemRepository itemRepository, ReadItem readItem) {
		this.itemRepository = itemRepository;
		this.readItem = readItem;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<Item> items = readItem.getListOfItemsFromCsvFile();
		itemRepository.saveAll(items);
		log.info("Loading data...");
 	}

}
