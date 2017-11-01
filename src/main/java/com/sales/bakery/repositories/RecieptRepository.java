package com.sales.bakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.bakery.domain.Reciept;

public interface RecieptRepository  extends JpaRepository<Reciept, Long> {}

