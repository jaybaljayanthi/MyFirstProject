package com.niit.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CategoryDao;
//import com.niit.dao.ProductDao;
import com.niit.models.Category;
//import com.niit.models.Product;

@Controller
public class CategoryController {

	
	@Autowired
	private CategoryDao categoryDao;
	
	public CategoryController()
	{
		System.out.println("CategoryController bean is created");
	}
	
	@RequestMapping(value="/admin/getallcategories")
	public String getAllCategories(Model model)
	{
		List<Category> categories=categoryDao.getAllCategories();
		
		model.addAttribute("categoryList",categories);
		return "listofcategories";
	}
	
	
	@RequestMapping(value="/admin/deletecategories/{id}")
	public String deleteCategory(@PathVariable int id)
	{
		categoryDao.deleteCategory(id);
		
		
		return "redirect:/admin/getallcategories";
		
	}
}
