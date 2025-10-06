package com.example.weightGraphApp.service;

import org.apache.ibatis.annotations.Param;

import com.example.weightGraphApp.entity.LoginUser;

public interface UserService {
	void insert(LoginUser user);
	Double showHight(LoginUser user);
	void delete(@Param("id")Integer id);
}
