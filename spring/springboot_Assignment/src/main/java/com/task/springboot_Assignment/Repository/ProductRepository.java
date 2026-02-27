package com.task.springboot_Assignment.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.springboot_Assignment.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategoryCategoryId(int categoryId);

    List<Product> findByProductNameContaining(String name);
}
