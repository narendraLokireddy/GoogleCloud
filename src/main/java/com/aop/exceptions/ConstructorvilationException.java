package com.aop.exceptions;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.spring.form.Registration;

@Component
@Aspect
public class ConstructorvilationException   {

	@AfterThrowing(pointcut="execution(* com.spring.dao.*.*.(..))",throwing="ex")
	public void checkhandle(Exception ex) {
		System.out.println("please change username");
		
	}
	@Around("execution(* com.spring.controller.FormController.saveRegistration(..))")
	public ModelAndView registerAround(ProceedingJoinPoint jp) throws Throwable {
		
	
	Object[] args = jp.getArgs();
	Registration registration=(Registration) args[0];
	
	ModelAndView mv=new ModelAndView();
	
	
	if(registration.getUsername()==null|registration.getUsername().equals("")) {
		mv.addObject("username","username should not empty");
		
	}

	if(registration.getPassword()==null |registration.getPassword().equals("")) {
		mv.addObject("password", "password should not empty");
		
	}
	
	

	if(registration.getRole()==null |registration.getRole().equals("")) {
		mv.addObject("role", "role should not empty");
		
	}
	
	
	
	if(mv.isEmpty()) {
	Object proceed = jp.proceed();
	mv.addObject(proceed);
	}
	
 
return null;
		
		
	
		
	}
	
}
