package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	
	public HomeController()
	{
		System.out.println("HomeController bean is instantiated");
	}
	
	 @RequestMapping(value="/home")   //  /home - KEY in Handler Map
		public String homePage(){  //  getHomePage()````````````` is the Value in Handler map
			System.out.println("homepage is executed");
			 return "home";   //logical view name
		}

	 
	 @RequestMapping(value="/aboutus")   //  /home - KEY in Handler Map
		public String aboutUs(){  //  getHomePage()````````````` is the Value in Handler map
			System.out.println("homepage is executed");
			 return "aboutus";   //logical view name
		}

}
