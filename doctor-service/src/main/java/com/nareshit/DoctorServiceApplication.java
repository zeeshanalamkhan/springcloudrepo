package com.nareshit;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DoctorServiceApplication {


	@Autowired
	private DataSource ds;
	
	public static void main(String[] args) {
		SpringApplication.run(DoctorServiceApplication.class, args);
	}
	
	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}
	
	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(jpaVendorAdapter());
		emf.setPersistenceUnitName("default");
		emf.afterPropertiesSet();
		return emf.getObject();
	}

	
	
}
