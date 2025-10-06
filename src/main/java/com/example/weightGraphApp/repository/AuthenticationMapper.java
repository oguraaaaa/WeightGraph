package com.example.weightGraphApp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.weightGraphApp.entity.Authentication;



@Mapper
public interface AuthenticationMapper {
	Authentication selectByUsername(String username);
}
