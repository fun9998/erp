package com.example.demo.service.Impl;

import com.example.demo.mapper.ImportanceMapper;
import com.example.demo.model.Importance;
import com.example.demo.service.ImportanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImportanceServiceImpl implements ImportanceService {
    @Autowired
    private ImportanceMapper importanceMapper;

    @Override
    public List<Importance> selectAll() {
        return importanceMapper.selectAll();
    }
}
