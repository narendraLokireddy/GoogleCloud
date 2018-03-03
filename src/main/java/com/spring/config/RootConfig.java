package com.spring.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"com"})
//@Import({SpringSecurityConfig.class})
@PropertySource("classpath:properties.properties")
public class RootConfig {
	@Autowired
	 public Environment env;
	
	 @Bean(autowire=Autowire.BY_TYPE)
	public DataSource getDataSource() {	 
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName(env.getProperty("D.class"));
		datasource.setUrl(env.getProperty("D.url"));
		datasource.setUsername(env.getProperty("D.username"));
		datasource.setPassword(env.getProperty("D.password"));
		return  datasource;
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public JdbcTemplate jtemp() {
		JdbcTemplate jtemp=new JdbcTemplate();
		return jtemp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
