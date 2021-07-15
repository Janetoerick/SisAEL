package com.ufrn.cb.SisAEL.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Seguranca extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests().
		antMatchers("/auth/logout").permitAll().
		anyRequest().permitAll().
		and().
		oauth2Login().
		and().
		logout().logoutSuccessUrl("/auth/logout");
	}
	

}
