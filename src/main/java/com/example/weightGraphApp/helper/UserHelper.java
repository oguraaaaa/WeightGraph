package com.example.weightGraphApp.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.Role;
import com.example.weightGraphApp.entity.User;
import com.example.weightGraphApp.form.UserForm;

public class UserHelper {
	
	public static User convertUser(UserForm form) {
		User user = new User();
		user.setHeight(form.getHeight());
		user.setDisplayName(form.getDisplayName());
		user.setLimitBw(((form.getHeight()/100)*(form.getHeight()/100))*18.5);
		
		return user;
		
	}
	
	public static UserForm convertUserForm(User user) {
		UserForm form = new UserForm();
		form.setDisplayName(user.getDisplayName());
		form.setHeight(user.getHeight());
		
		//更新画面設定
		form.setIsNew(false);
		return form;
	}
	
	public static Authentication convertAuth(UserForm form) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Authentication auth = new Authentication();
		auth.setUsername(form.getUsername());
		auth.setPassword(encoder.encode(form.getPassword()));
		auth.setDisplayname(form.getDisplayName());
		auth.setAuthority(Role.USER);
		return auth;
		
	}
}

