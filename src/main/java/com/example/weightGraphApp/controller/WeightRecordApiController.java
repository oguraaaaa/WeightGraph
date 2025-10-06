package com.example.weightGraphApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weightGraphApp.entity.WeightRecord;
import com.example.weightGraphApp.repository.WeightRecordMapper;

@RestController
@RequestMapping("/api/records")
public class WeightRecordApiController {

    private final WeightRecordMapper mapper;

    public WeightRecordApiController(WeightRecordMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<WeightRecord> getAllRecords() {
        // 日付昇順に並び替える（DBが降順なので）
        List<WeightRecord> list = mapper.showAll();
        list.sort((a, b) -> a.getRecordDay().compareTo(b.getRecordDay()));
        return list;
    }
}
