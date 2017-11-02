package com.sales.bakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.bakery.domain.Good;

public interface GoodRepository extends JpaRepository<Good, String> {}
