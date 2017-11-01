package com.sales.bakery.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reciept {

	@Id
	private Long recieptNumber;

	private String date;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Override
	public String toString() {
		return "Reciept ["
				+ (recieptNumber != null ? "recieptNumber=" + recieptNumber
						+ ", " : "") + (date != null ? "date=" + date : "") + ", "
				+ (customer.getId() != null ? "customerId=" + customer.getId() : "" ) + "]";
	}
	
}