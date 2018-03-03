package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.RegistrationDao;
import com.spring.form.Registration;

@Service
public class RegistrationService {
	@Autowired
	RegistrationDao dao;
	public int savedata(Registration reg) {
		return dao.insertUserdetails(reg);
	}

}
