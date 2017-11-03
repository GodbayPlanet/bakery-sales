package com.sales.bakery.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "recieptNumber")
	@ManyToOne(optional = false)
	private Reciept reciept;
	
	@JoinColumn(name = "good_id")
	@ManyToOne(optional = false)
	private Good good;
	
}
