package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDao;
//import com.niit.dao.ProductDao;
import com.niit.models.Category;
//import com.niit.models.Product;
import com.niit.models.Product;

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
	
	
	@RequestMapping(value="/admin/getupdatecategoryform/{id}")
	public String getUpdateCategoryForm(@PathVariable int id,Model model)
	{
		Category category=categoryDao.getCategory(id);
		model.addAttribute("category",category);
		model.addAttribute("categories",categoryDao.getAllCategories());
		return "updatecategoryform";
		
	}
	
	
	@RequestMapping(value="/admin/updatecategory")
	public String updateCategory(@Valid @ModelAttribute Category category,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("categories",categoryDao.getAllCategories());
			return "updatecategoryform";


		}
		categoryDao.updateCategory(category);
		
		return "redirect:/admin/getallcategories";
	}
	
	@RequestMapping(value="/admin/getcategoryform")
	public String getcategoryform(Model model)
	{
		Category c=new Category();
		model.addAttribute("category", c);
		model.addAttribute("categories",categoryDao.getAllCategories());
		return "categoryform";
	}
	
	@RequestMapping(value="/admin/addcategory")
	public String addcategory(@Valid @ModelAttribute(name="category") Category category,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("categories",categoryDao.getAllCategories());
			return "categoryform";
		}
		
		
		categoryDao.saveCategory(category);
		
		
		return "redirect:/admin/getallcategories";
	}
	
}
