package com.example.tuancan.controller;

import com.example.tuancan.model.Answer;
import com.example.tuancan.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping("/index")
    @ResponseBody
    public  Answer getAnswer(){
        Answer answer = answerService.selectOne(2);
        return answer;
    }
}