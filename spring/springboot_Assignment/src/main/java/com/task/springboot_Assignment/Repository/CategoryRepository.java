package com.task.springboot_Assignment.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.task.springboot_Assignment.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
