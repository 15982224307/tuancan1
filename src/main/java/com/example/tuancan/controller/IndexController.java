package com.example.tuancan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    /*主页*/
    @RequestMapping("/index")
    public String index(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().setAttribute("companyId",2);
        return "/groupmanager/index";
    }
}
