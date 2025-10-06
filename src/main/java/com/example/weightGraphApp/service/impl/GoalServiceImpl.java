package com.example.weightGraphApp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.weightGraphApp.entity.Goal;
import com.example.weightGraphApp.repository.GoalMapper;
import com.example.weightGraphApp.service.GoalService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {
	
	private final GoalMapper goalMapper;

	@Override
	public Goal leatest() {
		
		return goalMapper.leatest();
	}

	@Override
	public void insert(Goal goal) {
		goalMapper.insert(goal);

	}

}
