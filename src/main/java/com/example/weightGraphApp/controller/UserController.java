package com.example.weightGraphApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.User;
import com.example.weightGraphApp.form.UserForm;
import com.example.weightGraphApp.helper.UserHelper;
import com.example.weightGraphApp.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {
	
	private final UserService userService;
	
	@ModelAttribute
	public UserForm setForm() {		
		return new UserForm();
	}
	
	@GetMapping("/userForm")
	public String userForm(@ModelAttribute UserForm form,RedirectAttributes attributes){
		 long userCount = userService.count();
		    if (userCount >= 1) {
		        // 例外を投げる場合
		        // throw new IllegalStateException("既にユーザーが登録されています");

		        // メッセージを渡してリダイレクトする場合
		        attributes.addFlashAttribute("loginmessage", "ユーザーは既に登録されています。\n再登録する場合はログイン後にユーザー情報を削除してください。");
		        return "redirect:/login";
		    }

		form.setIsNew(true);
		return "userForm";
	}
	
	@PostMapping("/user/save")
	public String usersave(@Validated UserForm form,BindingResult bindingResult,RedirectAttributes attributes) {
		if(bindingResult.hasErrors()) {
			form.setIsNew(true);
			return "userForm";
		}
		
		attributes.addFlashAttribute("message","ユーザー登録しました。続けて目標を設定しましょう！");
		User user = UserHelper.convertUser(form);
		userService.insert(user);
		Authentication auth = UserHelper.convertAuth(form);
		userService.insertAuth(auth);
	
		
		
		return "redirect:/goal/goalSet";
	}
	

}
