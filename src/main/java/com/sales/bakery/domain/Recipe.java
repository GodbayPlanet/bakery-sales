package com.sales.bakery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recipe {

	@Id
	@GeneratedValue
	private Long recipeNumber;
	
	private String date;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	
}
