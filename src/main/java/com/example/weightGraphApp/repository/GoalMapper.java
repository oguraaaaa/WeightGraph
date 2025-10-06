package com.example.weightGraphApp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.weightGraphApp.entity.Goal;

@Mapper
public interface GoalMapper {
	//
	void insert(Goal goal);
	//取得
	Goal leatest();
}
