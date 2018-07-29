package com.example.tuancan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groupmanager")
public class groupManagerController {

    @RequestMapping("/index")
    public String index(){
        return "/groupmanager/index";
    }

    @RequestMapping("/tomorrow")
    public String tomorrowMenu(){

        return "redirect:/tomorrowmenu/menu";
    }

    @RequestMapping("/unit")
    public String unitMenu(){

        return "redirect:/unitmenu/menu";
    }
}
