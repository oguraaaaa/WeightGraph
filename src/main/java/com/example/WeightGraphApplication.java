package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@SpringBootApplication
public class WeightGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeightGraphApplication.class, args);
//		.getBean(WeightGraphApplication.class).exe();}
//
//private final WeightRecordMapper weightMapper;
//	
//	public void exe() {
//		for(WeightRecord rec:weightMapper.showAll()) {
//			System.out.println(rec);
//		}
	}
}
		

