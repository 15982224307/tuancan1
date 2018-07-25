package com.example.tuancan.controller;

import com.example.tuancan.model.Answer;
import com.example.tuancan.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping("/index1")
    @ResponseBody
    public  Answer getAnswer(){
        Answer answer = answerService.selectOne(2);
        return answer;
    }

    @RequestMapping("/empty")
    public  String empty(){

        return "/manager/empty";
    }

    @RequestMapping("/panel")
    public  String panel(){

        return "/manager/tab-panel";
    }
    @RequestMapping("/ui")
    public  String ui(){

        return "/manager/ui-elements";
    }
    @RequestMapping("/table")
    public  String teb(){

        return "/manager/table";
    }

    @RequestMapping("/groupmanager")
    public  String getGroupManager(HttpServletRequest httpServletRequest){

        httpServletRequest.getSession().setAttribute("companyId",2);
        return "/groupmanager/index";
    }

    @RequestMapping("/order2")
    public  String order2(){

        return "/webhtml/order";
    }

}
