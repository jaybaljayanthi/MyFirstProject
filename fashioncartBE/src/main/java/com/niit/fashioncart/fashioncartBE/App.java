package com.niit.fashioncart.fashioncartBE;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.dao.CategoryDao;
import com.niit.dao.CategoryDaoImpl;
import com.niit.models.Category;
//import com.niit.dao.ProductDao;
//import com.niit.dao.ProductDaoImpl;
//import com.niit.models.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,CategoryDaoImpl.class);
        CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDaoImpl");
        
        /*to save the product
        Product product=new Product();
        product.setProductname("computer");
        product.setProductdesc("computer");
        product.setPrice(1000);
        product.setQuantity(5);
        productDao.saveProduct(product);*/
        
        Category category=new Category();
        category.setCategoryname("shoes");
        categoryDao.saveCategory(category);


    }
}
