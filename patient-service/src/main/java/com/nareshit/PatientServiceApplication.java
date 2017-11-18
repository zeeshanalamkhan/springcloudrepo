package com.nareshit;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication
//@EnableAutoConfiguration
public class PatientServiceApplication implements CommandLineRunner{

	

	@Autowired
	private DataSource ds;
	
	public static void main(String[] args) {
	
		SpringApplication.run(PatientServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("current data source is:\t"+ds);
		System.out.println("i am in ");
	}

		
	
}
