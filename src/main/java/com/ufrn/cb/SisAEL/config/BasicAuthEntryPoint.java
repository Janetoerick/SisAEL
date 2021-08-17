package com.ufrn.cb.SisAEL.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

public class BasicAuthEntryPoint extends BasicAuthenticationEntryPoint{
	
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ex)  {
		
		System.out.println("ok");
		
	}
	
	
	@Override
	public void afterPropertiesSet() {
		
		System.out.println("okk");
	}

}
