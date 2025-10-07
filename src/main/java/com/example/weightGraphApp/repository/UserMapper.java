package com.example.weightGraphApp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.User;

@Mapper
public interface UserMapper {
	void insert(User user);
	Double insertAuth(Authentication auth);
	void delete(@Param("id")Integer id);
}
