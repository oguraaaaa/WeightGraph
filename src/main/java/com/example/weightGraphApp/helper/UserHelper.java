package com.example.weightGraphApp.helper;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.Role;
import com.example.weightGraphApp.entity.User;
import com.example.weightGraphApp.form.UserForm;

public class UserHelper {
	
	public static User convertUser(UserForm form) {
		User user = new User();
		user.setHight(form.getHight());
		user.setDisplayName(form.getDisplayName());
		user.setHight(form.getHight());
		user.setLimitBw(((form.getHight()/100)*(form.getHight()/100))*18.5);
		
		return user;
		
	}
	
	public static UserForm convertUserForm(User user) {
		UserForm form = new UserForm();
		form.setDisplayName(user.getDisplayName());
		form.setHight(user.getHight());
		
		//更新画面設定
		form.setIsNew(false);
		return form;
	}
	
	public static Authentication convertAuth(UserForm form) {
		Authentication auth = new Authentication();
		auth.setUsername(form.getUsername());
		auth.setPassword(form.getPassword());
		auth.setDisplayname(form.getDisplayName());
		auth.setAuthority(Role.user);
		return auth;
		
	}
}

