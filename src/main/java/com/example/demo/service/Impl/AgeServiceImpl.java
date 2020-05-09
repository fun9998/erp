package com.example.demo.service.Impl;

import com.example.demo.mapper.AgeMapper;
import com.example.demo.model.Age;
import com.example.demo.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgeServiceImpl implements AgeService {
    @Autowired
    private AgeMapper ageMapper;

    @Override
    public List<Age> selectAll() {
        return ageMapper.selectAll();
    }
}
