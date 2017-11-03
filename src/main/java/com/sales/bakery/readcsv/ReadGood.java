package com.sales.bakery.readcsv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sales.bakery.domain.Good;

@Component
public class ReadGood {

	private static final String FILE_NAME = "src/main/resources/csv/goods.csv";

	/**
	 * Returns list of goods from goods.cvs file.
	 * 
	 * @return
	 */
	public List<Good> getListOfGoodsFromCsvFile() {

		List<Good> goods = new ArrayList<>();

		try (BufferedReader bufferedReader = Files.newBufferedReader(
				Paths.get(FILE_NAME), StandardCharsets.UTF_8)) {
			String line = bufferedReader.readLine();

			while ((line = bufferedReader.readLine()) != null) {
				String[] cells = line.split(",");

				Good customer = createGood(cells);

				goods.add(customer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return goods;

	}

	/**
	 * Method return new Good object from String arrays that contain data.
	 * 
	 * @param cells
	 * @return
	 */
	public Good createGood(String[] cells) {
		String id = cells[0].replaceAll("'", "");
		String flavor = cells[1].replaceAll("'", "");
		String food = cells[2].replaceAll("'", "");
		double price = Double.valueOf(cells[3]);

		return new Good(id, flavor, food, price);
	}

}
