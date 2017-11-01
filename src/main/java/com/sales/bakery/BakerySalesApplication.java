package com.sales.bakery;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sales.bakery.domain.Customer;
import com.sales.bakery.domain.Reciept;
import com.sales.bakery.readcsv.ReadReciept;
import com.sales.bakery.services.CustomerService;

@Slf4j
@SpringBootApplication
public class BakerySalesApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(BakerySalesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Customer> customers = customerService.getAllCustomers();

		log.info("customers -> {}", customers);
		
//		ReadReciept readReciept = new ReadReciept();
//		
//		List<Reciept> receipts = readReciept.getListOfReceiptsFromCsvFile();
//		
//		receipts.forEach(reciept -> System.out.println(reciept));
	
//		List<Customer> customerss = ReadCustomer
//				.getListOfCustomersFormCsvFile();
//
//		customerss.forEach(customer -> System.out.println(customer));
		
//		insert into customer(id, last_name, first_name) values (21, "Vasic", "Nemanja");
//		insert into customer(id, last_name, first_name) values (22, "Vasic", "Ognjen");
//		insert into customer(id, last_name, first_name) values (23, "Vasic", "Ratko");

	}
}
