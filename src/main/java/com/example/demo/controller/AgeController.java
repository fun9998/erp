package com.example.demo.controller;

import com.example.demo.model.Age;
import com.example.demo.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AgeController {
    @Autowired
    private AgeService ageService;

    @RequestMapping("/age")
    @ResponseBody
    public List<Age> all(){
        return ageService.selectAll();
    }

}
