package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Category;
//import com.niit.models.Product;


@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Category saveCategory(Category category) {
		Session session =sessionFactory.getCurrentSession();
		System.out.println("Id of the category before persisting"+category.getId());
		session.save(category);
		System.out.println("Id of the category after persisting"+category.getId());
		return category;
	}

	@Override
	public Category getCategory(int id) {
		Session session=sessionFactory.getCurrentSession();
		Category category=(Category)session.get(Category.class,id);
		
		return category;
	}

	@Override
	public void updateCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();

		session.update(category);
	}

	@Override
	public void deleteCategory(int id) {
		Session session=sessionFactory.getCurrentSession();
		Category category=(Category)session.get(Category.class,id);
		
		if(category!=null)
		session.delete(category);
	}

	@Override
	public List<Category> getAllCategories() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		List<Category> categories=query.list();
		return categories;
	}

}
