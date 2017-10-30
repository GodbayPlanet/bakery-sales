package com.sales.bakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.bakery.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
