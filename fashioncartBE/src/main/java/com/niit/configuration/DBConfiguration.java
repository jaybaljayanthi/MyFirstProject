package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.models.Authorities;
import com.niit.models.BillingAddress;
import com.niit.models.Category;
import com.niit.models.Customer;
import com.niit.models.Product;
import com.niit.models.ShippingAddress;
import com.niit.models.User;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {

	
	public DBConfiguration()
	{
		System.out.println("DBConfiguration bean is created");
	}
	
	
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{	
		System.out.println("Entering DataSource Bean creation method");
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("DataSource bean"+dataSource);
		return dataSource;
	}
	
	@Bean
	public SessionFactory sessionFactory()
	{
		System.out.println("Entering sessionFactory creation method");
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		
		hibernateProperties.setProperty(
				"hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		
		hibernateProperties.setProperty("hibernate.show_sql","true");
		lsf.addProperties(hibernateProperties);
		
		
		Class classess[]=new Class[] {Product.class,Category.class,User.class,Customer.class,Authorities.class,BillingAddress.class,ShippingAddress.class};
		System.out.println("SessionFactory bean"+lsf);
		return lsf.addAnnotatedClasses(classess).buildSessionFactory();
	}
		
		@Bean
		public HibernateTransactionManager hibTransManagement()
		{
			return new HibernateTransactionManager(sessionFactory());
		}
		
}
