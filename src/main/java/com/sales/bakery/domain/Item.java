package com.sales.bakery.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	@EmbeddedId
	private ItemId item;

	private int ordinal;

	@Override
	public String toString() {
		return "Reciept: " + item.getReciept().getRecieptNumber()
				+ " Ordinal: " + ordinal + " Item: " + item.getGood().getId();
	}
}
