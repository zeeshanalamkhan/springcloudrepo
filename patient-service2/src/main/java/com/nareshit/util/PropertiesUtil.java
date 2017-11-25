package com.nareshit.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertiesUtil {
  
	@Autowired
	private Environment env;
	
	public String getValueFromKey(String key) {
		return env.getProperty(key);
	}
}
