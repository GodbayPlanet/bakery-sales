package com.sales.bakery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sales.bakery.domain.Reciept;
import com.sales.bakery.exceptions.NotFoundException;
import com.sales.bakery.repositories.RecieptRepository;

@Service
public class RecieptServiceImpl implements RecieptService {
	
	private RecieptRepository recieptRepository;
	
	public RecieptServiceImpl(RecieptRepository recieptrepository) {
		this.recieptRepository = recieptrepository;
	}
	
	@Override
	public List<Reciept> getAllReciepts() {
		return recieptRepository.findAll();
	}

	@Override
	public Reciept getByRecieptNumber(Long recieptNumber) {
		Optional<Reciept> recieptOptional = recieptRepository.findById(recieptNumber);
		
		if (!recieptOptional.isPresent()) {
			throw new NotFoundException("Reciept Not Found. For ID value: "
					+ recieptNumber.toString());
		}
		return recieptOptional.get();
	}

}
