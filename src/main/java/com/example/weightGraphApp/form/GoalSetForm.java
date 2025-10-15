package com.example.weightGraphApp.form;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalSetForm {
	
	
	
		@NotNull(message="体重は必須です。")
		@Range(min = 40,message="瘦せすぎは危険です！")
		private Double goalWeight;
		@Range(min = 12,message="瘦せすぎは危険です！")
		private Double goalFat;
		
		@Future(message="未来の日付を設定してください")
		private LocalDate goalDay;
		@Size(max=50,message="メモは{max}文字以内で入力してください。")
		private String memo;
		private Boolean isNew;
		
		
	}

