package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CartItemDao;
import com.niit.dao.ProductDao;
import com.niit.models.CartItem;



@Controller

public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private CartItemDao cartItemDao;
	
	public HomeController()
	{
		System.out.println("HomeController bean is instantiated");
	}
	
	 @RequestMapping(value="/home")   //  /home - KEY in Handler Map
		public String homePage(HttpSession session,@AuthenticationPrincipal Principal principal){  //  getHomePage()````````````` is the Value in Handler map
			
			 session.setAttribute("categories",productDao.getAllCategories());
			 if(principal!=null){
			 String email=principal.getName();
			 List<CartItem> cartItems=cartItemDao.getCart(email);
			 session.setAttribute("cartSize",cartItems.size());
			 }
			 return "home";
			 }

	 
	 @RequestMapping(value="/aboutus")   //  /home - KEY in Handler Map
		public String aboutUs(){  //  getHomePage()````````````` is the Value in Handler map
			System.out.println("homepage is executed");
			 return "aboutus";   //logical view name
		}
	 
	 @RequestMapping(value="/login")
	  public String login() {
		return "login";
	}
	 
	 @RequestMapping(value="/loginerror")
	 public String loginFailed(Model model) {
		 model.addAttribute("error", "Invalid credentials");
		 return "login";
		 
	 }
	 
	 @RequestMapping(value="/logout")
	 public String logout(Model model)
	 {
		 model.addAttribute("msg", "Logged out successfully.....");
		 return "login";
		 
	 }

}
