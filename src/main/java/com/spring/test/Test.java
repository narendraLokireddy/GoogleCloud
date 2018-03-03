package com.spring.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import com.das.bo.UserBo;
import com.das.dao.UserDao;
import com.das.security.service.UserDetailsServiceImpl;
import com.spring.config.RootConfig;
import com.spring.config.WebConfig;
import com.spring.service.PDF_EXCEL_SERVICE;

public class Test {
	
	
	
	public static void main(String[] args) {
		
		
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(RootConfig.class);
		PDF_EXCEL_SERVICE bean = context.getBean(PDF_EXCEL_SERVICE.class);
		
		System.out.println(bean.getBo());
		
		
		/*
		JourneyForm jform=new JourneyForm();
		jform.setSource("chennai");
		jform.setDestination("bangalore");
		jform.setBusNo(206);
		jform.setAmount(35);
		int save = bean.save(jform);
		System.out.println(save);*/
		
	}

}
