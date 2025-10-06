package com.example.weightGraphApp.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {	
	private String displayName;
	private double hight;
	private Boolean isNew;
}
