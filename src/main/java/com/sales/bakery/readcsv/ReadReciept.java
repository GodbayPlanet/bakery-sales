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
import com.sales.bakery.domain.Reciept;

@Component
public class ReadReciept {

	private static final String FILE_NAME = "src/main/resources/csv/receipts.csv";

	/**
	 * Method returns list of receipts from receipts.cv file. Variable line of
	 * type String reading line once before while loop, and again in while loop
	 * because we don't need first line of file.
	 * 
	 * @return
	 */
	public List<Reciept> getListOfReceiptsFromCsvFile() {
		List<Reciept> receipts = new ArrayList<>();

		try (BufferedReader bufferedReader = Files.newBufferedReader(
				Paths.get(FILE_NAME), StandardCharsets.UTF_8)) {

			String line = bufferedReader.readLine();

			while ((line = bufferedReader.readLine()) != null) {
				String[] cells = line.split(",");

				Reciept reciept = createReciept(cells);

				receipts.add(reciept);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return receipts;
	}

	/**
	 * Method returns Reciept object from data in String array.
	 * @param cells
	 * @return
	 */
	public Reciept createReciept(String[] cells) {
		Long recieptNumber = Long.valueOf(cells[0]);
		String date = cells[1].replaceAll("'", "");
		Long customerId = Long.valueOf(cells[2]);
		Customer customer = new Customer(customerId);

		return new Reciept(recieptNumber, date, customer);

	}
}
