package com.example.tuancan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tomorrowmenu")
public class TommorwMenuController {

    @RequestMapping("menu")
    public String menuAll(){
        return "/groupmanager/tomorrowmenu";
    }
}
