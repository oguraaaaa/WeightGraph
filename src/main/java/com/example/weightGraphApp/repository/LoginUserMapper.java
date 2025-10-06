package com.example.weightGraphApp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.weightGraphApp.entity.LoginUser;

@Mapper
public interface LoginUserMapper {
	void insert(LoginUser user);
	Double showHight(LoginUser user);
	void delete(@Param("id")Integer id);
}
