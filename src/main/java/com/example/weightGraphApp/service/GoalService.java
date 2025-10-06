package com.example.weightGraphApp.service;

import com.example.weightGraphApp.entity.Goal;

public interface GoalService {
	Goal leatest();
	void insert(Goal goal);
}
