package com.dotridge.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.dotridge.util.TokenValidator;

@Configuration
@Component
public class NovelHealthAuthenticationFilter implements Filter {

	@Autowired
	TokenValidator tokenValidator;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
         HttpServletRequest httpReq = (HttpServletRequest)req;
         HttpServletResponse httpResp = (HttpServletResponse)resp;
         
         String tokenKey = httpReq.getHeader("loginToken");
         System.out.println("token key is:\t"+tokenKey);
         boolean isValid = tokenValidator.isTokenValidated(tokenKey, new Date());
         if(isValid){
        	 System.out.println("Is valid\t"+isValid);
        	 chain.doFilter(req, resp);
         }else{
        	 httpResp.sendRedirect("./getHomePage");
         }
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());      
		
	}

}
