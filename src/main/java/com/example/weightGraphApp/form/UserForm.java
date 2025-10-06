package com.example.weightGraphApp.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {	
	@NotNull(message ="必須です。入力して下さい")
	@Size(min=2,max=10,message="2～10文字入力でしてください")
	private String displayName;
	@NotNull(message ="必須です。入力して下さい")
	private double hight;
	@NotNull(message ="必須です。入力して下さい")
	@Size(min=3,max=10,message="3～10文字で入力してください")
	private String username;
	@NotNull(message ="必須です。入力して下さい")
	@Size(min=3,max=10,message="3～10文字で入力してください")
	private String password;
	private Boolean isNew;
}
