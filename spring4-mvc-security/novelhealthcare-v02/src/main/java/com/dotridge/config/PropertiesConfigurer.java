package com.dotridge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource("classpath:database.properties")
public class PropertiesConfigurer {

	@Autowired
	private Environment env;
	
	public String getPropertyValue(String key) {
		String value = env.getProperty(key);
		System.out.println("value is:\t"+value);
		
		return value;
	}
}
