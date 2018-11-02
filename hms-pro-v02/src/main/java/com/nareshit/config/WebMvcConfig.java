package com.nareshit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class WebMvcConfig {
	
	
	@Bean
	@Order(value=1)
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
		
	}
	
	@Bean
	public InternalResourceViewResolver internalViewResolver() {
		InternalResourceViewResolver views = new InternalResourceViewResolver();
		views.setPrefix("/WEB-INF/views/");
		views.setSuffix(".jsp");
		return views;
		
	}

	@Bean
	public TilesConfigurer  tilesConfigurer() {
		TilesConfigurer tilesConfig = new TilesConfigurer();
		String[] definitions = new String[] {"/WEB-INF/hospital-definitions.xml"};
		tilesConfig.setDefinitions(definitions);
		return tilesConfig;
		
	}
}
