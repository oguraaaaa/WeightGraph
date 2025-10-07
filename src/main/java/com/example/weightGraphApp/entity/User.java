package com.example.weightGraphApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String displayName;	
	private Double height;	
	private Double limitBw;
}
