package com.example.weightGraphApp.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightRecord {
	private Integer id;
	private double weight;
	private double fat;
	private String memo;
	private LocalDate recordDay;
	private Boolean isNew;
	private LoginUser user;
}
