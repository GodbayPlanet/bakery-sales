package com.sales.bakery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sales.bakery.domain.Good;
import com.sales.bakery.exceptions.NotFoundException;
import com.sales.bakery.repositories.GoodRepository;

@Service
public class GoodServiceImpl implements GoodService {

	private GoodRepository goodRepository;

	public GoodServiceImpl(GoodRepository goodRepository) {
		this.goodRepository = goodRepository;
	}

	@Override
	public List<Good> getAllGoods() {
		return goodRepository.findAll();
	}

	@Override
	public Good getByGoodId(String id) {

		Optional<Good> goodOptional = goodRepository.findById(id);

		if (!goodOptional.isPresent()) {
			throw new NotFoundException("Good Not Found. For ID value: " + id);
		}
		return goodOptional.get();
	}

}
