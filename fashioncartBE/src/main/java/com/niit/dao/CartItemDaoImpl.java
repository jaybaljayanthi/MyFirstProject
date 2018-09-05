package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.CartItem;
import com.niit.models.User;


@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addToCart(CartItem cartItem) {
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		
	}

	@Override
	public User getUser(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		return user;

	}

	@Override
	public List<CartItem> getCart(String email) {
		
		Session session=sessionFactory.getCurrentSession();
		//cartItem has user,user has email
		Query query=session.createQuery("from CartItem where user.email=?");
		query.setString(0, email);
		List<CartItem> cartItems=query.list();
		return cartItems;
		
	}

	@Override
	public void removeCartItem(int cartItemId) {
		
		Session session=sessionFactory.getCurrentSession();
		CartItem cartItem =(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
		
		
	}

}
