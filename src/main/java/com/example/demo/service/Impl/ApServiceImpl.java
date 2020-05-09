package com.example.demo.service.Impl;

import com.example.demo.mapper.ApMapper;
import com.example.demo.model.Ap;
import com.example.demo.service.ApService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApServiceImpl implements ApService {
    @Autowired
    private ApMapper apMapper;

    @Override
    public List<Ap> selectAll() {
        return apMapper.selectAll();
    }
}
