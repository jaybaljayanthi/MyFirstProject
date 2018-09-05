package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartItemDao;
import com.niit.dao.ProductDao;
import com.niit.models.CartItem;
import com.niit.models.Customer;
import com.niit.models.Product;
import com.niit.models.ShippingAddress;
import com.niit.models.User;

@Controller
public class CartItemController {
	
	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/cart/addtocart/{productId}")
	public String addToCart(@PathVariable int productId,@RequestParam int requestedQuantity,@AuthenticationPrincipal Principal principal )
	{
		if(principal==null)
			return "login";
		String email=principal.getName();
		Product product=productDao.getProduct(productId);
		User user=cartItemDao.getUser(email);
		List<CartItem> cartItems=cartItemDao.getCart(email);
		for(CartItem cartItem:cartItems) {
			if(cartItem.getProduct().getId()==productId) {
				cartItem.setQuantity(requestedQuantity);
				cartItem.setTotalPrice(requestedQuantity*product.getPrice());
				cartItemDao.addToCart(cartItem);//update the quantity and totalprice
				return"redirect:/cart/getcart";

			}
		}
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(requestedQuantity);
		cartItem.setProduct(product);
		cartItem.setUser(user);
		double totalPrice=requestedQuantity*product.getPrice();
		cartItem.setTotalPrice(totalPrice);
		cartItemDao.addToCart(cartItem);
		return"redirect:/cart/getcart";
		
		
	}
	@RequestMapping(value="/cart/getcart")

	public String getCart(@AuthenticationPrincipal Principal principal,Model model) {
		
		if(principal==null)
			return "login";
		
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDao.getCart(email);
		model.addAttribute("cartItems",cartItems);
		return "cart";
	}
	
	
	@RequestMapping(value="/cart/removecartitem/{cartItemId}")
	public String removeCartItem(@PathVariable int cartItemId) {
		
		cartItemDao.removeCartItem(cartItemId);
		return "redirect:/cart/getcart";
	}

	
	@RequestMapping(value="/cart/clearcart")
	public String clearCart(@AuthenticationPrincipal Principal principal) {
		
		List<CartItem> cartItems=cartItemDao.getCart(principal.getName());
		for(CartItem cartItem:cartItems) {
			cartItemDao.removeCartItem(cartItem.getCartItemId());
		}
		
		return "redirect:/cart/getcart";

	}
	
	@RequestMapping(value="/cart/shippingaddressform")
    public String getShippingAddressForm(@AuthenticationPrincipal Principal principal,Model model){
    	if(principal==null)
    		return "login";
    	String email=principal.getName();
    	User user=cartItemDao.getUser(email);
    	Customer customer=user.getCustomer();
    	ShippingAddress shippingAddress=customer.getShippingaddress();
    	model.addAttribute("shippingaddress",shippingAddress);
    	return "shippingaddress";
    }
	
}
