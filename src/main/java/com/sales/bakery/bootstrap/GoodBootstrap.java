package com.sales.bakery.bootstrap;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sales.bakery.domain.Good;
import com.sales.bakery.readcsv.ReadGood;
import com.sales.bakery.repositories.GoodRepository;

@Slf4j
@Component
public class GoodBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final GoodRepository goodRepository;
	private final ReadGood readGood;
	
	public GoodBootstrap(GoodRepository goodRepository, ReadGood readGood) {
		this.goodRepository = goodRepository;
		this.readGood = readGood;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<Good> goods = readGood.getListOfGoodsFromCsvFile();
		goodRepository.saveAll(goods);
		log.info("Loading data...");
	}

}
