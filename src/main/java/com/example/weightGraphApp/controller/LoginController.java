package com.example.weightGraphApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.weightGraphApp.form.LoginForm;


@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public String showLogin(@ModelAttribute LoginForm form) {
		//templatesフォルダ配下のlogin.htmlに遷移
		return "entry";
	
}
}
