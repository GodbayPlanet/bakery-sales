package com.sales.bakery.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reciept {

	@Id
	private Long recieptNumber;

	private String date;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Reciept(Long recieptNumber, String date, Customer customer) {
		this.recieptNumber = recieptNumber;
		this.date = date;
		this.customer = customer;
	}
	
	/**
	 * This constructor is needed for creating Item object in ReadItem class.
	 * @param recieptNumber
	 */
	public Reciept(Long recieptNumber) {
		this.recieptNumber = recieptNumber;
	}

	@Override
	public String toString() {
		return "Reciept ["
				+ (recieptNumber != null ? "recieptNumber=" + recieptNumber
						+ ", " : "") + (date != null ? "date=" + date : "") + ", "
				+ (customer.getId() != null ? "customerId=" + customer.getId() : "" ) + "]";
	}
	
}