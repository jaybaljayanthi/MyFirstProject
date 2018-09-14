package com.niit.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.models.Product;

import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase {

	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
    ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");

	public void testSaveProduct() {
		Product product=productDao.getProduct(3);
		product.setPrice(100);
		product.setQuantity(1);
		product.setProductname("WaterBottle");
		product.setProductdesc("Blue color");
		product=productDao.saveProduct(product);
		
	}

	public void testGetProduct() {
		Product product1=productDao.getProduct(36);
		Product product2=productDao.getProduct(1);
		Product product3=productDao.getProduct(2);

		//null or notnull
		assertNotNull(product1);
		assertNull(product2);
		assertNotNull(product3);

		//check for price
		double expectedPrice=85;
		double actualPrice=product1.getPrice();
		assertTrue(expectedPrice==actualPrice);
	}
	
	
	
	public void testGetAllProducts()
	{
		List<Product> products=productDao.getAllProducts();
		assertTrue(products.size()>0);
		assertFalse(products.isEmpty());
		
		
	}


}
