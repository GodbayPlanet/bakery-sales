package com.sales.bakery.bootstrap;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sales.bakery.domain.Reciept;
import com.sales.bakery.readcsv.ReadReciept;
import com.sales.bakery.repositories.RecieptRepository;

@Slf4j
@Component
public class RecieptBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final RecieptRepository recieptRepository;
	
	private ReadReciept readReciept;
	
	public RecieptBootstrap(RecieptRepository recieptRepository, ReadReciept readReciept)  {
		this.recieptRepository = recieptRepository;
		this.readReciept = readReciept;
	}
	
	/**
	 * Method gets all receipts from receipts.csv file and save them into database.
	 */
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<Reciept> receipts = readReciept.getListOfReceiptsFromCsvFile();
		recieptRepository.saveAll(receipts);
		log.info("Loading Bootstrap data.");
	}

}
