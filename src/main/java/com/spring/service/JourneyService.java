package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.JourneyDao;
import com.spring.form.JourneyForm;

@Service

public class JourneyService {
	@Autowired
	public JourneyDao jd;

	public int save(JourneyForm jform) {
		
		return jd.saveJourney(jform);
		
		
		
	}
	
	
	
	
	
}
