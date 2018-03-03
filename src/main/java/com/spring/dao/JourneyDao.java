package com.spring.dao;

 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.form.JourneyForm;

@Repository
public class JourneyDao {

	public static final String  insert="insert into jsd(source,destination,busNo,amount,journeyDate,gender,country,aboutYou,community) values(?,?,?,?,?,?,?,?,?)";
	
	 
	@Autowired
	public JdbcTemplate jtemplate;
	//'nllore','hyd','20-JUL-1995',3,33
	
	
	public int saveJourney(JourneyForm jform) {
 int update = jtemplate.update(insert,new Object[] {
		 jform.getSource(),jform.getDestination() ,jform.getBusNo(),jform.getAmount(),jform.getJourneyDate(),
		 
		 jform.getGender(),jform.getCountry(),jform.getAboutYou(),jform.getCommunity()});
 System.out.println(update);
  return update;
  }		
	}
	
	
