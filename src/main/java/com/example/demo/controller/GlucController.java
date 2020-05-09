package com.example.demo.controller;

import com.example.demo.model.Gluc;
import com.example.demo.service.GlucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GlucController {
    @Autowired
    private GlucService glucService;

    @RequestMapping("/gluc")
    @ResponseBody
    public List<Gluc> all(){
        return glucService.selectAll();
    }

}
