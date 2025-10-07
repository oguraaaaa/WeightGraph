package com.example.weightGraphApp.service;

import org.apache.ibatis.annotations.Param;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.User;

public interface UserService {
	void insert(User user);
	void insertAuth(Authentication auth);
	void delete(@Param("id")Integer id);
}
