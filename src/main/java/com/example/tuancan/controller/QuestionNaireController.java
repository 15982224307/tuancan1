package com.example.tuancan.controller;

import com.example.tuancan.service.QuestionNaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author xiaoqy
 * @Date 2018/8/3
 * @Description
 */
@Slf4j
@RequestMapping("questionNaire")
@Controller
public class QuestionNaireController {

    @Autowired
    private QuestionNaireService questionNaireService;


    @RequestMapping(value = "/show",method = {RequestMethod.GET,RequestMethod.POST})
    public String show(Model model){

        return "";
    }
}
