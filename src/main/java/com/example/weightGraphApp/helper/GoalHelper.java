package com.example.weightGraphApp.helper;

import com.example.weightGraphApp.entity.Goal;
import com.example.weightGraphApp.form.GoalSetForm;


public class GoalHelper {
	public static Goal convertGoal(GoalSetForm form) {
		Goal goal = new  Goal();
		goal.setGoalDay(form.getGoalDay());
		goal.setGoalWeight(form.getGoalWeight());
		goal.setGoalFat(form.getGoalFat());
		goal.setMemo(form.getMemo());
		return goal;
	}
	
	public static GoalSetForm convertGoalSetForm(Goal goal) {
		GoalSetForm form = new GoalSetForm();
		form.setGoalDay(goal.getGoalDay());
		form.setGoalWeight(goal.getGoalWeight());
		form.setGoalFat(goal.getGoalFat());
		form.setMemo(goal.getMemo());
		//更新画面設定
		form.setIsNew(false);
		return form;
	}
	
	
}
