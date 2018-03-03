package com.spring.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.form.Registration;
@Component
public class RegistationDetailsValidation implements Validator {

	@Override
	public boolean supports(Class<?> classType) {
		// TODO Auto-generated method stub
		 
		return classType.equals(Registration.class);
	}

	@Override
	public void validate(Object obj, Errors error) {
		// TODO Auto-generated method stub
		
		Registration reg=(Registration)obj;
		
		if(reg.getUsername()==null | reg.getUsername().equals("")) {
			error.reject("username","username.blank");
		}
		if(reg.getPassword()==null| reg.getPassword().equals("")) {
			error.reject("password","password.blank");
		}
		if(reg.getRole()==null||reg.getRole().equals("")) {
			error.reject("role","role.blank");
			
		}
		
	}

}
