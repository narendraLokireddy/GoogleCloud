package com.spring.config;

import java.net.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

import com.das.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
/*
 In custom login form, you have to follow Spring Security standard name : 
 1.j_spring_security_check � Login service 
 2. j_spring_security_logout � Logout service 
 3. j_username � Username 
 4. j_password � Password
 */

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public UserDetailsServiceImpl impl;
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception { auth .inMemoryAuthentication()
	 * .withUser("admin").password("123").roles("ADMIN"); }
	 */

	/*
	 * @Autowired public ExceptionMappingAuthenticationFailureHandler handler;
	 * 
	 * 
	 * @Bean public ExceptionMappingAuthenticationFailureHandler gethandler() {
	 * ExceptionMappingAuthenticationFailureHandler handler=new
	 * ExceptionMappingAuthenticationFailureHandler();
	 * handler.setDefaultFailureUrl(""); return handler; }
	 */

	/*
	 * @Autowired public DataSource dataSource;
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		        .antMatchers("/usersexcel").authenticated()
				.antMatchers("/request.htm", "/users.htm", "/userspdf.htm", "Registration.htm").permitAll().and()
				.formLogin().loginPage("/login.htm").usernameParameter("j_username").passwordParameter("j_password")
				.loginProcessingUrl("/j_spring_security_check").failureUrl("/login.htm?error")
				.failureHandler(authenticationFailure()).and().logout().clearAuthentication(true)
				.logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login.htm?logout").and().csrf();
	}
	
	/*
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   // TODO Auto-generated method stub
	    
	 auth.jdbcAuthentication().usersByUsernameQuery("select username,password,enabled from USERS1 where username = ?").authoritiesByUsernameQuery("select username,role from ROLES1 where username = ?");
	 }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(impl);

	}

	@Bean
	public ExceptionMappingAuthenticationFailureHandler authenticationFailure() {
		ExceptionMappingAuthenticationFailureHandler handler = new ExceptionMappingAuthenticationFailureHandler();
		handler.setDefaultFailureUrl("/login.htm?error");
		return handler;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
