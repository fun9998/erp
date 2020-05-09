package com.example.demo.service.Impl;

import com.example.demo.mapper.AgeMapper;
import com.example.demo.mapper.CardioMapper;
import com.example.demo.model.Age;
import com.example.demo.model.Cardio;
import com.example.demo.service.AgeService;
import com.example.demo.service.CardioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardioServiceImpl implements CardioService {
    @Autowired
    private CardioMapper cardioMapper;

    @Override
    public List<Cardio> all() {
        return cardioMapper.selectAll();
    }
}
