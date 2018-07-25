package com.example.tuancan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ManagerController {


    @RequestMapping("/frame/{area}")
    public String getTop(@PathVariable(name = "area") String area){
        //顶部
        if (area.equals("top")){
            return "/manager/top";
          //左边
        }else if (area.equals("left")){

            return "/manager/left";
        //默认的中间
        }else if (area.equals("rjsj")){

            return "/manager/rjsj";
        }

        return "";


    }
    @RequestMapping("/frame/group/{grouparea}")
    public String getGroupTop(@PathVariable(name = "grouparea") String grouparea) {
        //顶部
        if (grouparea.equals("top")) {
            return "/groupmanager/top";
            //左边
        } else if (grouparea.equals("left")) {

            return "/groupmanager/left";
            //默认的中间
        } else if (grouparea.equals("hy_list")) {

            return "/manager/hy_list";
        }

        return "";
    }


}
