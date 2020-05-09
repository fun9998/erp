package com.example.demo.service.Impl;

import com.example.demo.mapper.GlucMapper;
import com.example.demo.model.Gluc;
import com.example.demo.service.GlucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlucServiceImpl implements GlucService {
    @Autowired
    private GlucMapper glucMapper;

    @Override
    public List<Gluc> selectAll() {
        return glucMapper.selectAll();
    }
}
