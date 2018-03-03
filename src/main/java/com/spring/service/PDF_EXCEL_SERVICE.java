package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.bo.UserBo;
import com.das.bo.UserBo1;
import com.spring.dao.PDF_EXCEL_DAO;

@Service
public class PDF_EXCEL_SERVICE {
@Autowired
	PDF_EXCEL_DAO  dao;
	public List<UserBo1> getBo(){
		
		List<UserBo1> regitionDetails = dao.regitionDetails();
		return regitionDetails;
	}
	
}
