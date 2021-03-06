package com.in28minutes.springboot.web.controller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.model.Todo;

import com.in28minutes.springboot.web.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	private String getlistoftodos(ModelMap model) {
		// TODO Auto-generated method stub
		String username = getLoggedinUserName();
		System.out.println(username);
		model.put("todos", service.retrieveTodos(username));

		return "list-todos";
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

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	private String showaddtodo(ModelMap model) {
		// TODO Auto-generated method stub
		model.put("todo", new Todo(0, getLoggedinUserName(), "", new Date(), false));
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	private String addtodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		// TODO Auto-generated method stub
		if (result.hasErrors()) {
			return "todo";
		}
		service.addTodo(getLoggedinUserName(), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	private String showupdatetodo(ModelMap model,@RequestParam int id) {
		// TODO Auto-generated method stub
		// System.out.println(todo.getId()+ (String) model.get("name")+
		// todo.getDesc()+ todo.getTargetDate()+ todo.isDone());
		Todo todo=service.retrieveTodo(id);
		model.put("todo",todo);
		
		
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	private String updatetodo(ModelMap model,@Valid Todo todo,BindingResult result ) {
		// TODO Auto-generated method stub
	
		if(result.hasErrors())
		{
			return"todo";
		}
		todo.setUser(getLoggedinUserName());
		service.updateTodo(todo);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	private String deletetodo(@RequestParam int id) {
		// TODO Auto-generated method stub
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

}
