package com.example.weightGraphApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.weightGraphApp.entity.WeightRecord;
import com.example.weightGraphApp.repository.WeightRecordMapper;
import com.example.weightGraphApp.service.WeightGraphService;

import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class WeightGraphServiceImpl implements WeightGraphService {
	
	private final WeightRecordMapper weightMapper;
	@Override
	public List<WeightRecord> showAll() {
		
		return weightMapper.showAll();
	}

	@Override
	public void insert(WeightRecord weightrecord) {
		weightMapper.insert(weightrecord);

	}

	@Override
	public void update(WeightRecord weightrecord) {
		weightMapper.update(weightrecord);

	}

	@Override
	public void delete(Integer id) {
		weightMapper.delete(id);

	}

	@Override
	public WeightRecord show(Integer id) {
		return weightMapper.show(id);
		
	}

	@Override
	public WeightRecord leatest() {
		return weightMapper.leatest();
	}

}
