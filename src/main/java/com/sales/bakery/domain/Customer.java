package com.sales.bakery.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Recipe> recipes;
	
	public Customer(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
