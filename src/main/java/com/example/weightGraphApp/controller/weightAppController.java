package com.example.weightGraphApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.Goal;
import com.example.weightGraphApp.entity.User;
import com.example.weightGraphApp.entity.WeightRecord;
import com.example.weightGraphApp.form.GoalSetForm;
import com.example.weightGraphApp.form.LoginForm;
import com.example.weightGraphApp.form.RecordWeightForm;
import com.example.weightGraphApp.form.UserForm;
import com.example.weightGraphApp.helper.GoalHelper;
import com.example.weightGraphApp.helper.UserHelper;
import com.example.weightGraphApp.helper.WeightHelper;
import com.example.weightGraphApp.service.GoalService;
import com.example.weightGraphApp.service.UserService;
import com.example.weightGraphApp.service.WeightGraphService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weight")
public class weightAppController {
	
	private final WeightGraphService weightGraph;
	private final GoalService goalService;
	private final UserService userService;
	
	@GetMapping
	public String gate() {
		return "/login";
	}
	
	
	@GetMapping("/userForm")
	public String userForm(@ModelAttribute UserForm form){
		form.setIsNew(true);
		return "userForm";
	}
	
	@PostMapping("/user/save")
	public String usersave(@Validated UserForm form,BindingResult bindingResult,RedirectAttributes attributes) {
		if(bindingResult.hasErrors()) {
			form.setIsNew(true);
			return "userForm";
		}
		
		attributes.addFlashAttribute("message","ユーザー登録しました。続けて目標を設定しましょう！");
		User user = UserHelper.convertUser(form);
		userService.insert(user);
		Authentication auth = UserHelper.convertAuth(form);
		userService.insertAuth(auth);
	
		
		
		return "redirect:/weight/goalSet";
	}
	
	
	@GetMapping("/noset")
	public String nosetStart(RedirectAttributes attributes) {
		attributes.addFlashAttribute("loginmessage","ログインして体重を記録しましょう！");
		return "redirect:/login";
	}
	
	@GetMapping("/main")
	public String maintPage(Model model) {
		
		 var allRecords = weightGraph.showAll();
		    var latestRecord = weightGraph.leatest();
		    var goal = goalService.leatest();

		    if (allRecords != null && !allRecords.isEmpty()) {
		        model.addAttribute("WeightRecords", allRecords);
		    }
		    if (latestRecord != null) {
		        model.addAttribute("leatest", latestRecord);
		    }
		    if (goal != null) {
		        model.addAttribute("goal", goal);
		    }
//
//		model.addAttribute("WeightRecords",weightGraph.showAll());	
//		model.addAttribute("leatest",weightGraph.leatest());
//		model.addAttribute("goal",goalService.leatest());
		return "main";
	}
	
	
	@GetMapping("/form")
	public String record(@ModelAttribute RecordWeightForm form) {
		//画面設定
		form.setIsNew(true);
		return "form";
		
	}
	
	@GetMapping("/goalSet")
	public String goalSet(@ModelAttribute GoalSetForm form) {
		form.setIsNew(true);
		return "goalSetForm";
	}
	
	@PostMapping("/goal/save")
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
	
//	@GetMapping("/autologin")
//	public String autologin(@ModelAttribute LoginForm form,RedirectAttributes attributes) {
//		attributes.addFlashAttribute("loginmessage","目標を設定しました。ログインして体重を記録しましょう！");
//		return "autologin";
//	}
	
	@PostMapping("/save")
	public String insert(@Validated RecordWeightForm form,BindingResult bindingResult,RedirectAttributes attributes) {
		if(bindingResult.hasErrors()) {
			form.setIsNew(true);
			return "form";
		}
		//エンティティへの変換
		WeightRecord record = WeightHelper.convertRecord(form);
		weightGraph.insert(record);
		attributes.addFlashAttribute("message","記録が追加されました");
		return "redirect:/weight/main";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,RedirectAttributes attributes) {
		//削除処理
		weightGraph.delete(id);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message","削除されました");
		//PRGパターン
		return "redirect:/weight/main";
	}
	
	//IDで修正画面表示
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable Integer id,Model model,
				RedirectAttributes attributes) {
			//取得
			WeightRecord target = weightGraph.show(id);
			if(target != null) {
				//対象データがある場合はFormへの変換
				RecordWeightForm form = WeightHelper.convertRecordWeightForm(target);
				//モデルに格納
				model.addAttribute("recordWeightForm",form);
				return "form";
			}else {
				//対象データがない場合フラッシュメッセージ
				attributes.addFlashAttribute("errorMessage","対象データがありません");
				//一覧画面へ
				return "redirect:/weight/main";
			}
		}
	//経過日数
//	@GetMapping("/pass")
//	public String getTime(Model model) {
//		LocalDateTime now = LocalDateTime.now();
//		LocalDate start = Goal.getStartDay();
//		
//	    model.addAttribute("pass",LocalDateTime.now() - Goal.getStartDay()));
//	    return "pass";
//	}
//		
	//情報更新
	@PostMapping("/update")
	public String update(@Validated RecordWeightForm form,
			BindingResult bindingResult,
			RedirectAttributes attributes) {
		//===バリデーションチェック===
		//入力チェックNG:入力画面を表示する
		if(bindingResult.hasErrors()) {
			//更新画面の設定
			form.setIsNew(false);
			return "form";
		}
		//エンティティへの変換
		WeightRecord record = WeightHelper.convertRecord(form);
		//更新処理
		weightGraph.update(record);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message","編集されました");
		//PRGパターン
		return "redirect:/weight/main";
	}
	
	 @GetMapping("/chart")
	    public String showChartPage() {
	        return "chartView"; // chart.html
	    }
	
}
