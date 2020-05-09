package com.example.demo.controller;

import com.example.demo.model.Cholesterol;
import com.example.demo.service.CholesterolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CholesterolController {
    @Autowired
    private CholesterolService cholesterolService;

    @RequestMapping("/cholesterol")
    @ResponseBody
    public List<Cholesterol> all(){
        return cholesterolService.selectAll();
    }

}
