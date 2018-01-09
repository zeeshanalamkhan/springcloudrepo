package com.dotridge.restcontroller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sun.net.www.protocol.http.AuthCache;

import com.dotridge.bean.LoginBean;
import com.dotridge.bean.TokenBean;
import com.dotridge.bean.UserProfileBean;
import com.dotridge.service.ManageUserProfileService;
import com.dotridge.service.RegistrationService;
import com.dotridge.util.AuthenticationUtil;
import com.dotridge.util.DateUtil;
import com.dotridge.util.LDAPUtil;

//@Controller
@RestController
@RequestMapping("/manageUserApi")
public class ManageUserprofileRestCntrl {

	@Autowired
	RegistrationService regService;
	
	@Autowired
	ManageUserProfileService profileService;
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String getAllUsers(){
		return "john";
	}
	
	@RequestMapping(value="/createUser",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public UserProfileBean createUser(@RequestBody UserProfileBean upb){
		TokenBean tb = new TokenBean();
	      upb = regService.createUser(upb);	
		  String genToken = LDAPUtil.getLoginTokenUserId(upb.getUserId());
		  if(genToken != null){
				tb.setToken(genToken);
				tb.setTokenCreationTime(DateUtil.getStringFromDate(new Date()));
				tb = profileService.generateToken(tb);  
		  }
		  
		return upb;
	}
	
	@RequestMapping(value="/createUser.xml",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_XML_VALUE)
	public UserProfileBean createUserXML(@RequestBody UserProfileBean upb){
		
	      upb = regService.createUser(upb);	
		 
		return upb;
	}
	
	
	@PostMapping(value="/authenticate",consumes="application/json",produces="application/json")
	public TokenBean authenticate(@RequestBody LoginBean login){
		TokenBean tb = null;
		boolean isAuthenticated = LDAPUtil.authenticateUser(login.getUserId(), login.getPassword());
		if(isAuthenticated){
			String loginToken = LDAPUtil.getLoginTokenUserId(login.getUserId());
			tb = profileService.getTokenByTokenKey(loginToken);
			
			Authentication auth = AuthenticationUtil.getAuthorizationToken(login.getUserId(), login.getPassword());
			SecurityContextHolder.getContext().setAuthentication(auth);
			
		}
		return tb;
	}
	
	
}
