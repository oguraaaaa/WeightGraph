package com.example.weightGraphApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.weightGraphApp.entity.Goal;
import com.example.weightGraphApp.form.GoalSetForm;
import com.example.weightGraphApp.form.LoginForm;
import com.example.weightGraphApp.helper.GoalHelper;
import com.example.weightGraphApp.service.GoalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/goal")
public class GoalController {
	
	private final GoalService goalService;
	
	@ModelAttribute
	public GoalSetForm setForm() {		
		return new GoalSetForm();
	}

	@GetMapping("/goalSet")
	public String goalSet(@ModelAttribute GoalSetForm form) {
		form.setIsNew(true);
		return "goalSetForm";
	}
	//
	@PostMapping("/save")
	public String goalSave(@Validated GoalSetForm form,BindingResult bindingResult,@ModelAttribute LoginForm logform,RedirectAttributes attributes) {
		if(bindingResult.hasErrors()) {
			form.setIsNew(true);
			return "goalSetForm";
		}
		
		attributes.addFlashAttribute("loginmessage","目標を設定しました。ログインして体重を記録しましょう！");
		Goal goal = GoalHelper.convertGoal(form);
		goalService.insert(goal);
		return "redirect:/login";
	}
	
	@GetMapping("/edit")
	public String goalEdit(@ModelAttribute GoalSetForm form, Model model,RedirectAttributes attributes) {
		Goal target = goalService.leatest();
		if(target != null) {
			//対象データがある場合はFormへの変換
			GoalSetForm gform = GoalHelper.convertGoalSetForm(target);
			//モデルに格納
			model.addAttribute("goalSetForm",gform);
			return "goalSetForm";
		}else {
			form.setIsNew(true);
			return "goalSetForm";
		}
	}
	
	@PostMapping("/update")
	public String goalpdate(@Validated GoalSetForm form,
			BindingResult bindingResult,
			RedirectAttributes attributes) {
		//===バリデーションチェック===
		//入力チェックNG:入力画面を表示する
		if(bindingResult.hasErrors()) {
			//更新画面の設定
			
			return "form";
		}
		//エンティティへの変換
		Goal goal = GoalHelper.convertGoal(form);
		//更新処理
		goalService.insert(goal);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message","目標設定完了！");
		//PRGパターン
		return "redirect:/weight/main";
	}
	
}
