package com.example.weightGraphApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.weightGraphApp.form.LoginForm;


@Controller
@RequestMapping
public class LoginController {
	
	@GetMapping
	public String gate() {
		return "/login";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		 model.addAttribute("loginForm", new LoginForm());
		//templatesフォルダ配下のentry.htmlに遷移
		return "entry";
	
}
}
