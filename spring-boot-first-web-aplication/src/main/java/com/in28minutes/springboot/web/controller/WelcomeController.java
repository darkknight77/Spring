package com.in28minutes.springboot.web.controller;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller

public class WelcomeController {
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String showWelcome(ModelMap model) {
		// TODO Auto-generated method stub
		// System.out.println("Name :"+name);
		
		 model.put("name", getLoggedinUserName());
		return "Welcome";
	}
	
	
	public String getLoggedinUserName()
	{
		
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if(principal instanceof UserDetails)
	{
		return((UserDetails)principal).getUsername();
	}
	return principal.toString();
	}
	

	
}
