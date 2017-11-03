package com.sales.bakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.bakery.domain.Item;
import com.sales.bakery.domain.ItemId;

public interface ItemRepository extends JpaRepository<Item, ItemId> {}
