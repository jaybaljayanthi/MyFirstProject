package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.ProductDao;



@Controller

public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	public HomeController()
	{
		System.out.println("HomeController bean is instantiated");
	}
	
	 @RequestMapping(value="/home")   //  /home - KEY in Handler Map
		public String homePage(HttpSession session){  //  getHomePage()````````````` is the Value in Handler map
			
		session.setAttribute("categories",productDao.getAllCategories());
		 
		 System.out.println("homepage is executed");
			 return "home";   //logical view name
		}

	 
	 @RequestMapping(value="/aboutus")   //  /home - KEY in Handler Map
		public String aboutUs(){  //  getHomePage()````````````` is the Value in Handler map
			System.out.println("homepage is executed");
			 return "aboutus";   //logical view name
		}

}
