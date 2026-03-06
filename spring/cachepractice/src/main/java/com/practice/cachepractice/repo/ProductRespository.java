package com.practice.cachepractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.cachepractice.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer> {
	

}
