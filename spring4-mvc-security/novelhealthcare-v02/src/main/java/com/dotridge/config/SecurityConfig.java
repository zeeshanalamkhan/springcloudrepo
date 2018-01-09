package com.dotridge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CutomAuthenticationProvider authProvider;
	
	@Autowired
	CustomPermissionEvaluator permEval;
	
	@Bean
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		DefaultMethodSecurityExpressionHandler expressionHandler = 
		          new DefaultMethodSecurityExpressionHandler();
		        expressionHandler.setPermissionEvaluator(permEval);
		        return expressionHandler;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("aim in security config");
		http.authorizeRequests().antMatchers("/**").permitAll().and().formLogin()
				.loginProcessingUrl("/j_spring_security_check").failureUrl("/j_spring_security_check?error")
				.defaultSuccessUrl("/formLogin").usernameParameter("j_username").passwordParameter("j_password").and()
				.logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/getHomePage").and().csrf().disable();
	}

	/*
	 * Use this method when no method level authorization enabled
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authProvider);
	}

	/**
	 * Use this method when authentication and method level authorization enabled
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	
	
}
