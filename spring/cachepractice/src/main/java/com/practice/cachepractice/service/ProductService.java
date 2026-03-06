package com.practice.cachepractice.service;

import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.practice.cachepractice.entity.Product;
import com.practice.cachepractice.repo.ProductRespository; 



@Service
public class ProductService {

	
private ProductRespository repository;
	
	public ProductService(ProductRespository repository) {
		this.repository = repository;
	}
	
	@CachePut(cacheNames = "product" ,key = "#result.id")
	public Product addProduct(Product p) {
		return repository.save(p);
	}
	
	@Cacheable(cacheNames = "product",key = "#id")
	public Product getById(int id) {
	    return repository
	            .findById(id)
	            .orElseThrow(() -> new RuntimeException("Id is not present"));
	}
	

}
