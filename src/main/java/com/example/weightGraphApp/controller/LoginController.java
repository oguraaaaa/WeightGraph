package com.example.weightGraphApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.weightGraphApp.form.LoginForm;


@Controller
@RequestMapping
public class LoginController {
	
	@ModelAttribute
	public LoginForm setForm() {		
		return new LoginForm();
	}
	
	@GetMapping("/login")
	public String showLogin(@ModelAttribute LoginForm form) {
		//templatesフォルダ配下のentry.htmlに遷移
		return "entry";
	
}
}
