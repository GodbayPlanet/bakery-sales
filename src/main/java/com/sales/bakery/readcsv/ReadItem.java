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
import com.sales.bakery.domain.Item;
import com.sales.bakery.domain.ItemId;
import com.sales.bakery.domain.Reciept;

@Component
public class ReadItem {

	private static final String FILE_NAME = "src/main/resources/csv/items.csv";

	/**
	 * Method returns list of items from items.cv file. Variable line of type
	 * String reading line once before while loop, and again in while loop
	 * because we don't need first line of file.
	 * 
	 * @return
	 */
	public List<Item> getListOfItemsFromCsvFile() {
		List<Item> items = new ArrayList<>();

		try (BufferedReader bufferedReader = Files.newBufferedReader(
				Paths.get(FILE_NAME), StandardCharsets.UTF_8)) {

			String line = bufferedReader.readLine();

			while ((line = bufferedReader.readLine()) != null) {
				String[] cells = line.split(",");

				Item item = createItem(cells);

				items.add(item);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

	/**
	 * Method returns Item object from data in String array.
	 * 
	 * @param cells
	 * @return
	 */
	public Item createItem(String[] cells) {
		Integer ordinal = Integer.valueOf(cells[1].trim());
		Long recieptId = Long.valueOf(cells[0]);
		String goodId = cells[2].replaceAll("'", "");
		
		Reciept reciept = new Reciept(recieptId);
		Good good = new Good(goodId);
		
		ItemId itemId = new ItemId(reciept, good);
		
		return new Item(itemId, ordinal.intValue());
	}

}
