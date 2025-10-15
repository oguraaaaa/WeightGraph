package com.example.weightGraphApp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.weightGraphApp.form.GoalSetForm;
import com.example.weightGraphApp.service.UserService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class BwValidator implements Validator {
	
	private final UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return GoalSetForm.class.isAssignableFrom(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//対象のFormを取得
				GoalSetForm form =(GoalSetForm)target;
				Double limitBw = userService.show().getLimitBw();
				
//				 // Spring Securityからログインユーザーを取得
//		        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		        if (principal instanceof LoginUser loginUser) {
//		       //     User user = loginUser.getUser(); // ← LoginUserにUserを持たせている場合

		            if (form.getGoalWeight() < limitBw) {
		                errors.rejectValue("goalWeight", null,
		                        "痩せすぎは危険です。BMI 18.0(" + limitBw + "kg)以上の値を設定してください");		            
		        } else {
		            // principalが想定外の型（匿名ユーザーなど）
		            errors.reject("user.not.logged.in", "情報が取得できませんでした。");
		        }
//				if(form.getGoalWeight() < user.getLimitBw()) {					
//						errors.rejectValue("goalWeight", null,
//								"痩せすぎは危険です。BMI 18.5(" + user.getLimitBw() +	"kg)以上の値を設定してください");
//					}
				}

}
