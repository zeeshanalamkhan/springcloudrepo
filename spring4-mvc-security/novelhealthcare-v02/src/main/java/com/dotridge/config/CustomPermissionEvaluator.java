package com.dotridge.config;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	public boolean hasPermission(Authentication authentication, Object module, Object permission) {
		Collection<? extends GrantedAuthority> authList = authentication.getAuthorities();
		if(authList != null && !authList.isEmpty()){
			/*for(GrantedAuthority auth : authList){
				if(auth.getAuthority().equals(module.toString())){
					
				}
			}*/
			/*if(authList.contains(module.toString()) && authList.contains(permission.toString())){
				return true;
			}*/
			
			boolean isModuleChecked = false;
			for(GrantedAuthority gt : authList){
				if(gt.getAuthority().equals(module.toString())){
					isModuleChecked = true;
					continue;
				}
				
				if(gt.getAuthority().equals(permission.toString()) && isModuleChecked){
					return true;
				}else{
					continue;
				}
			}
		}
		
		
		return false;
	}

	public boolean hasPermission(Authentication arg0, Serializable arg1, String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
