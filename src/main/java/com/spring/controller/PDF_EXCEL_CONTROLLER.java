package com.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.das.bo.UserBo1;
import com.spring.service.PDF_EXCEL_SERVICE;

@Controller
public class PDF_EXCEL_CONTROLLER {
 
	@Autowired
	PDF_EXCEL_SERVICE service;
	
    /**
     * Handle request to the default page
    
 
    /**
     * Handle request to download an Excel document
     */
	 @RequestMapping(value = "/users.htm")
	    public String downloadExcelorPdf(Model mv) {
	    	List<UserBo1> users= service.getBo();
	    	System.out.println(users);
	    mv.addAttribute("users", users);
	    	return "users";
	    }
    @RequestMapping(value = "/userspdf.htm")
    public ModelAndView downloadExcelorPdf() {
    
    /*	List<UserBo1> users=new ArrayList<UserBo1>();
    	UserBo1 bo=new UserBo1();
    	bo.setUsername("Narendra");
    	bo.setPassword("123");
    	bo.setRole("ROLE");
    	users.add(bo);*/
    	List<UserBo1> users1= service.getBo();
    	
     for(int i=0;i<users1.size();i++) {
    	UserBo1 userBo1 = users1.get(i);
    	System.out.println(userBo1.getUsername()+userBo1.getPassword()+userBo1.getRole());
     }
    	
    	
    	return new ModelAndView("pdfView","userspdf", users1);
    }
    @RequestMapping(value = "/usersexcel")
    public ModelAndView downloadExcelorExcel() {
    
    	
    	
    	List<UserBo1> users1= service.getBo();
    	
    	System.out.println(users1);
    		
    	
    	
    	
    	return new ModelAndView("excelView","usersexcel", users1);
    }

    
    
}