package com.example.weightGraphApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weightGraphApp.entity.Goal;
import com.example.weightGraphApp.repository.GoalMapper;

@RestController
@RequestMapping("/api/goal")
public class GoalApiController {

    private final GoalMapper goalMapper;

    public GoalApiController(GoalMapper goalMapper) {
        this.goalMapper = goalMapper;
    }

    @GetMapping
    public Goal getLatestGoal() {
        return goalMapper.leatest();  // 最新目標データを返す
    }
}
