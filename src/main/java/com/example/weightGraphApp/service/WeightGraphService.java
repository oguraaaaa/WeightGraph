package com.example.weightGraphApp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.weightGraphApp.entity.WeightRecord;

public interface WeightGraphService {

		//一覧表示
		List<WeightRecord> showAll();
		//idで1件取得
		WeightRecord show(Integer id);
		//最新表示
		WeightRecord leatest();				
		//体重登録
		void insert(WeightRecord weightrecord);
		//更新
		void update(WeightRecord weightrecord);
		//削除
		void delete(@Param("id")Integer id);
}
