package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aop.exceptions.BadUserNameException;
import com.spring.form.Registration;

@Repository
public class RegistrationDao {
	
	private String INSERTUSER_DETAILS="INSERT INTO USERS(USER_NM,PASSWORD_NM,ROLE_NM)VALUES(?,?,?)";
	
	@Autowired
	public JdbcTemplate template;
	
	public int insertUserdetails(Registration reg) {
		
		int update = template.update(INSERTUSER_DETAILS, new Object[] {reg.getUsername(),reg.getPassword(),reg.getRole()});
		
		if(update >=0) {
			return  update;
		}else {
			throw new BadUserNameException("badusername");
		}
		
	}

}
