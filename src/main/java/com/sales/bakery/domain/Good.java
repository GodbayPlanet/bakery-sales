package com.sales.bakery.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Good {
	
	@Id
	private String id;
	
	private String flavor;
	private String food;
	private double price;
	
	/**
	 * This constructor is needed for creating Item object in ReadItem class.
	 * @param id
	 */
	public Good(String id) {
		this.id = id;
	}
	
	public Good(String id, String flavor, String food, double price) {
		this.id = id;
		this.flavor = flavor;
		this.food = food;
		this.price = price;
	}
	
}
