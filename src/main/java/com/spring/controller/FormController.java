package com.spring.controller;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.form.JourneyForm;
import com.spring.form.Registration;
import com.spring.service.JourneyService;
import com.spring.service.RegistrationService;


@Controller
public class FormController {
	@Autowired
	public JourneyService jservice;
	 
	@Autowired
	public RegistrationService rservice;
	 
	@RequestMapping(method=RequestMethod.GET,path="/request.htm")
	public String journeydispacher(Model mv) {
		JourneyForm jform=new JourneyForm();
        mv.addAttribute("Journey", jform);
		return "Journey";
	}
	/*@RequestMapping(method=RequestMethod.POST)
	public String view(@RequestParam(name="source") String source,
	@RequestParam(name="destination") String destination,
	
	@RequestParam(name="busNo") int busNo,
	@RequestParam(name="amount") float amount) {
		
		JourneyForm journey=new JourneyForm();
		journey.setAmount(amount);
		journey.setSource(source);
		journey.setDestination(destination);
		journey.setBusNo(busNo);
		System.out.println("hai");
		jservice.save(journey);
		
		
		return "sucess";
	}*/
	/*
	@RequestMapping(method=RequestMethod.POST)
	public String view(@ModelAttribute("journey") JourneyForm journey) {		
		System.out.println("hai");
		int save = jservice.save(journey);
		
		
		return "sucess";
	}
	
*/	
	 
 
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
 
        model.setViewName("login");
        return model;
    }
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public ModelAndView logoutPage() {
 
        ModelAndView model = new ModelAndView();
        model.setViewName("logout");
        return model;
    }

	
	@RequestMapping(method=RequestMethod.POST,path="/request.htm")
	public String view(ServletRequest req) throws ParseException {
		String source=req.getParameter("source");
		String destination=req.getParameter("destination");
		int busNo=Integer.parseInt(req.getParameter("busNo"));
		float amount=Float.parseFloat(req.getParameter("amount"));
		
	   String parameter = req.getParameter("journeyDate");
	   SimpleDateFormat formate=new SimpleDateFormat("dd-MMM-yyy");
	   java.util.Date journeyDate = formate.parse(parameter);
	   
	   String gender=req.getParameter("gender");
	   String country=req.getParameter("country");
	   String aboutYou=req.getParameter("aboutYou");
	   String community=req.getParameter("community");
	  /* String mailingList=req.getParameter("mailingList");*/
	   
		JourneyForm journey=new JourneyForm();
		journey.setAmount(amount);
		journey.setSource(source);
		journey.setDestination(destination);
		journey.setBusNo(busNo);
		journey.setJourneyDate(journeyDate);
		journey.setGender(gender);
		journey.setCountry(country);
		journey.setAboutYou(aboutYou);
		journey.setCommunity(community);
		/*journey.setMailingList(mailingList);
		*/
		System.out.println("hai");
		jservice.save(journey);
		
		
		return "sucess";
		}
		
		 
		@RequestMapping(value="/registration.htm",method=RequestMethod.GET)
		public String register(Model mv) {
			Registration register=new Registration();
			mv.addAttribute("Registration", register);
			return "Registration";
		}
		@RequestMapping(value="/registration.htm",method=RequestMethod.POST)
		public String saveRegistration( @ModelAttribute("Registration") Registration registration) {
			 			int savedata = rservice.savedata(registration);
			
			return "sucess";
		}
		
		
		
	}
	
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


