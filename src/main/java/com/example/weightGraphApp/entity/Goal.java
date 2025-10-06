package com.example.weightGraphApp.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
	private Double goalWeight;
	private Double goalFat;
	private Double startWeight;
	private String memo;
	private LocalDate startDay;
	private LocalDate goalDay;
	private Boolean isNew;
	private LoginUser user;
}