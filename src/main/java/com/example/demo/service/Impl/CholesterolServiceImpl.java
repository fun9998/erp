package com.example.demo.service.Impl;

import com.example.demo.mapper.CholesterolMapper;
import com.example.demo.model.Cholesterol;
import com.example.demo.service.CholesterolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CholesterolServiceImpl implements CholesterolService {
    @Autowired
    private CholesterolMapper cholesterolMapper;

    @Override
    public List<Cholesterol> selectAll() {
        return cholesterolMapper.selectAll();
    }
}
