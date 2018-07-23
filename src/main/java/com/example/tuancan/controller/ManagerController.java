package com.example.tuancan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frame")
public class ManagerController {

    @RequestMapping("/{area}")
    public String getTop(@PathVariable(name = "area") String area){
        //顶部
        if (area.equals("top")){
            return "/manager/top";
          //左边
        }else if (area.equals("left")){

            return "/manager/left";
        //默认的中间
        }else if (area.equals("hy_list")){

            return "/manager/hy_list";
        }

        return "";
    }


}
