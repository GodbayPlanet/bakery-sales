package com.sales.bakery.services;

import java.util.List;

import com.sales.bakery.domain.Good;

public interface GoodService {

	List<Good> getAllGoods();

	Good getByGoodId(Long id);
}
