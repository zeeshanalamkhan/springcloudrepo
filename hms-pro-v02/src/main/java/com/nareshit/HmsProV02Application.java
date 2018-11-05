package com.nareshit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class HmsProV02Application {

	public static void main(String[] args) {
		SpringApplication.run(HmsProV02Application.class, args);
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionfactory() {
		return new HibernateJpaSessionFactoryBean();
	}
	
	
}
