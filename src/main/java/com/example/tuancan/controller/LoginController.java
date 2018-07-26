package com.example.tuancan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {

    @RequestMapping("/index")
    public String loginIndex(){

        return "/groupmanager/companystaff_index";
    }
}
