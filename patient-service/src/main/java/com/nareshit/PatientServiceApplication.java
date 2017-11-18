package com.nareshit;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.orm.hibernate5.SpringSessionContext;





@SpringBootApplication
//@EnableAutoConfiguration
//@EnableTransactionManagement
public class PatientServiceApplication implements CommandLineRunner{

	

	@Autowired
	private DataSource ds;
	
	public static void main(String[] args) {
			
		SpringApplication.run(PatientServiceApplication.class, args);
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("current data source is:\t"+ds);
		System.out.println("i am in ");
	}

		
	
}
