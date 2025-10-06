package com.example.weightGraphApp.helper;

import com.example.weightGraphApp.entity.LoginUser;
import com.example.weightGraphApp.form.UserForm;

public class LoginUserHelper {
	
	public static LoginUser convertUser(UserForm form) {
		LoginUser user = new  LoginUser();
		user.setName(form.getName());
		user.setHight(form.getHight());
		return user;
	}
	
	public static UserForm convertUserForm(LoginUser user) {
		UserForm form = new UserForm();
		form.setName(user.getName());
		form.setHight(user.getHight());
		
		//更新画面設定
		form.setIsNew(false);
		return form;
	}
}
