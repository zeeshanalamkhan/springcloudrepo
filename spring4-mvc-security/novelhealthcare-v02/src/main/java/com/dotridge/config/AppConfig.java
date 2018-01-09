package com.dotridge.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.dotridge.util.ServiceConstants;

@Configuration
@ComponentScan(basePackages = {"com.dotridge.service",
		"com.dotridge.config",
		"com.dotridge.dao",
		"com.dotridge.util"})
public class AppConfig {
	
	/*@Autowired
	private PropertiesConfigurer props;*/
	
	@Bean
	public DataSource createDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/capam");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	/*@Bean
	public DataSource createDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(props.getPropertyValue(ServiceConstants.DB_DRIVER));
		ds.setUrl(props.getPropertyValue(ServiceConstants.DB_URL));
		ds.setUsername(props.getPropertyValue(ServiceConstants.DB_USER));
		ds.setPassword(props.getPropertyValue(ServiceConstants.DB_USER_PWD));
		return ds;
	}
*/
	@Bean
	public LocalSessionFactoryBean createSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(createDataSource());
		factoryBean.setPackagesToScan("com.dotridge.domain");
		Properties props = new Properties();
		props.put("hibernate.show_sql", true);
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		props.put("hibernate.cache.use_second_level_cache", true);
		props.put("hibernate.cache.use_query_cache", true);
		factoryBean.setHibernateProperties(props);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager createTransaction(SessionFactory sf) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sf);
		return transactionManager;

	}
}
