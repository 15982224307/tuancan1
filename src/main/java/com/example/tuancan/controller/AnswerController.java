package com.example.tuancan.controller;

import com.example.tuancan.service.AnswerService;
import com.example.tuancan.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping("/index1")
    public  String getAnswer(HttpServletRequest request){
        System.out.println(JsonUtil.toJson(request.getParameterMap()));
       // Answer answer = answerService.selectOne(2);
       // return answer;
        return "manager/404";
    }

    @RequestMapping("/index")
    public  String index(HttpServletRequest request){

        request.getSession(true).setAttribute("unitID","1");
        request.getSession(true).setAttribute("dcno","1");
        return "/manager/pt_index";
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
    public  String getGroupManager(){
        return "/groupmanager/index";
    }

    @RequestMapping("/order2")
    public  String order2(){

        return "/webhtml/order";
    }

}
