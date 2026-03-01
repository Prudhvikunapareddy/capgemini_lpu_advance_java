package com.capgemini.Ass_Lms.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.Ass_Lms.Entity.Category;
import com.capgemini.Ass_Lms.Repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryjpa;
	
	public Category addCategory(Category c) {
		return categoryjpa.save(c);
	}
	
	public Category getCategoryById(Long id) {
		return categoryjpa.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
	}
	
	public List<Category> getAllCategories(){
		return categoryjpa.findAll();
	}
	
	public Category updateCategory(Long id , Category update) {
		Category obj = getCategoryById(id);
		obj.setName(update.getName());
		obj.setDescription(update.getDescription());
		return categoryjpa.save(obj);
	}
	
	public void deleteCategory(Long id) {
		Category obj = getCategoryById(id);
		categoryjpa.delete(obj);
	}

}