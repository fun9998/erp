package com.example.demo.controller;

import com.example.demo.model.Ap;
import com.example.demo.service.ApService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ApController {
    @Autowired
    private ApService apService;

    @RequestMapping("/ap")
    @ResponseBody
    public List<Ap> all(){
        return apService.selectAll();
    }

}
