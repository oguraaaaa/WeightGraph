package com.example.weightGraphApp.service;

import org.apache.ibatis.annotations.Param;

import com.example.weightGraphApp.entity.User;

public interface UserService {
	void insert(User user);
	Double showHight(User user);
	void delete(@Param("id")Integer id);
}
