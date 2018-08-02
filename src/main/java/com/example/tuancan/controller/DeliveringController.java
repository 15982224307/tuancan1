package com.example.tuancan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/delivering")
public class DeliveringController {

    @RequestMapping("/creat")
    public String creatDelivering(){
        return "/groupmanager/delivering";
    }
}
