package com.niit.dao;

import java.util.List;

import com.niit.models.Category;
//import com.niit.models.Product;

public interface CategoryDao {
	
	Category saveCategory(Category category);
	Category getCategory(int id);
	void updateCategory(Category category);
	void deleteCategory(int id);
	//List<Product> getAllProducts();
	List<Category> getAllCategories();

}
