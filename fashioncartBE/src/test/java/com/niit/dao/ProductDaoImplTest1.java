package com.niit.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.models.Product;

import junit.framework.TestCase;

public class ProductDaoImplTest1 extends TestCase {

public void testUpdateProduct() {
	
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
    ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
		
		Product product=productDao.getProduct(4);
		product.setPrice(2000);
		product.setQuantity(25);
		productDao.updateProduct(product);
		assertTrue(product.getPrice()==2000);
		assertTrue(product.getQuantity()==25);
		
	}

}
