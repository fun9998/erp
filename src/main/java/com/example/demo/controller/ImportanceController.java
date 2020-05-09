package com.example.demo.controller;

import com.example.demo.model.Importance;
import com.example.demo.service.ImportanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ImportanceController {
    @Autowired
    private ImportanceService importanceService;

    @RequestMapping("/importance")
    @ResponseBody
    public List<Importance> all(){
        return importanceService.selectAll();
    }

}
