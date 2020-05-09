package com.example.demo.service;


import com.example.demo.model.Cardio;
import com.example.demo.model.Cardio_plus;

public interface PredictService {
    String predict(Cardio_plus cardio_plus);
}
