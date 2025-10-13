package com.example.weightGraphApp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.weightGraphApp.entity.WeightRecord;

@Mapper
public interface WeightRecordMapper {
	//一覧表示
	List<WeightRecord> showAll();
	//idで表示
	WeightRecord show(Integer id);
	//最新表示
	WeightRecord leatest();
	//体重登録
	void insert(WeightRecord wr);
	//更新
	void update(WeightRecord wr);
	//削除
	void delete(@Param("id")Integer id);
	void deleteAll();
}
