package com.nareshit;


import java.io.BufferedReader;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.orm.hibernate5.SpringSessionContext;

import com.zaxxer.hikari.HikariDataSource;





@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
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
		HikariDataSource hd = (HikariDataSource)ds;
		System.out.println("current pool is:\t"+hd.getJdbcUrl());
		
		System.out.println("max pool size:\t"+hd.getMaximumPoolSize());
		System.out.println("min idel time is:\t"+hd.getMinimumIdle());
		
		System.out.println(hd.getConnection().getMetaData().getConnection().getSchema());
		Properties props = hd.getConnection().getMetaData().getConnection().getClientInfo();
		for(Object key : props.keySet()) {
			System.out.println("key is:\t"+key);
			System.out.println("value is:\t"+props.get(key));
			

		}

		
		System.out.println("i am in ");
	}

		
	
}
