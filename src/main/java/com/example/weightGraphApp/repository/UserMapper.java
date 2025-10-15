package com.example.weightGraphApp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.User;

@Mapper
public interface UserMapper {
	void insert(User user);
	Double insertAuth(Authentication auth);
	void delete();
	void deleteAuth();
	long count();
	User show();
}
