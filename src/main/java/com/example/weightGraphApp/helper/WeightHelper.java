package com.example.weightGraphApp.helper;

import com.example.weightGraphApp.entity.WeightRecord;
import com.example.weightGraphApp.form.RecordWeightForm;

public class WeightHelper {
	public static WeightRecord convertRecord(RecordWeightForm form) {
		WeightRecord record = new WeightRecord();
		record.setId(form.getId());
		record.setWeight(form.getWeight());
		record.setFat(form.getFat());
		record.setMemo(form.getMemo());
		record.setRecordDay(form.getRecordDay());
		return record;
	}
	
	public static RecordWeightForm convertRecordWeightForm(WeightRecord record) {
		RecordWeightForm form = new RecordWeightForm();
		form.setId(record.getId());
		form.setWeight(record.getWeight());
		form.setFat(record.getFat());
		form.setMemo(record.getMemo());
		form.setRecordDay(record.getRecordDay());
		//更新画面設定
		form.setIsNew(false);
		return form;
	}
	

}
