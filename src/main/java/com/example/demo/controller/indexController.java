package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class indexController {


    @RequestMapping("/")
    public String re_index() {
        return "index.html";
    }

    @RequestMapping("/test")
    public String test() {
        return "predict.html";
    }

    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/t1")
    public String t1(Model model){
        List<String> col_n = Arrays.asList("城市名字，薪资");
        model.addAttribute("col_n","col_n");
        model.addAttribute("items","items");
        model.addAttribute("table_num","1");
        return "_table.html";
    }

}

@Controller
@RequestMapping("/t")
class tableController{


    @RequestMapping("")
    public String re_index() {
        return "index1.html";
    }


    @RequestMapping("t3")
    public String table3(Model model){
        model.addAttribute("table_num",3);
        return "_table";
    }
}