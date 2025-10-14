package com.example.weightGraphApp.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordWeightForm {
	private Integer id;
	
	@Positive(message = "値が不正です")
	@NotNull(message="体重は必須です")
	private Double weight;
	
	@Positive(message = "値が不正です")
	private Double fat;
	@Size(min=0,max=30,message="メモは{max}文字以内で入力してください。")
	private String memo;
	@NotNull(message="日付を選択してください")
	@PastOrPresent
	private LocalDate recordDay;
	private Boolean isNew;
}
