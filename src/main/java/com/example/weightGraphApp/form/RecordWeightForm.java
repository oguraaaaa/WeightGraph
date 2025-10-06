package com.example.weightGraphApp.form;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordWeightForm {
	private Integer id;	
	private double weight;
	private double fat;
	@Size(min=0,max=50,message="メモは{max}文字以内で入力してください。")
	private String memo;
	private LocalDate recordDay;
	private Boolean isNew;
}
