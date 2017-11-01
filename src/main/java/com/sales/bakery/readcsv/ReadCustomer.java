package com.sales.bakery.readcsv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sales.bakery.domain.Customer;

@Component
public class ReadCustomer {

	 private static final String FILE_NAME = "src/main/resources/csv/customers.csv";

	/**
	 * Returns list of customers from file customers.csv.
	 * 
	 * @return
	 */
	public List<Customer> getListOfCustomersFormCsvFile() {
		List<Customer> customers = new ArrayList<>();

		try (BufferedReader bufferedReader = Files.newBufferedReader(
				Paths.get(FILE_NAME), StandardCharsets.UTF_8)) {
			String line = bufferedReader.readLine();

			while ((line = bufferedReader.readLine()) != null) {
				String[] cells = line.split(",");

				Customer customer = createCustomer(cells);

				customers.add(customer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customers;
	}

	/**
	 * Returns Customer object from String array.
	 * 
	 * @param cells
	 * @return
	 */
	private Customer createCustomer(String[] cells) {
		Long id = Long.valueOf(cells[0]);
		String lastName = cells[1].replaceAll("'", "");
		String firstName = cells[2].replaceAll("'", "");

		return new Customer(id, firstName, lastName);
	}
}
