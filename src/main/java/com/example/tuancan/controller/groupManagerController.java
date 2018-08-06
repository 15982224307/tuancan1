package com.example.tuancan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groupmanager")
/*所有页面都是通过转发到达的*/
public class groupManagerController {

    /*主页*/
    @RequestMapping("/index")
    public String index(){
        return "/groupmanager/index";
    }

    /*明日菜单 */
    @RequestMapping("/tomorrow")
    public String tomorrowMenu(){

        return "redirect:/tomorrowmenu/menu";
    }

    /*用餐单文菜单*/
    @RequestMapping("/unit")
    public String unitMenu(){

        return "redirect:/unitmenu/menu";
    }

    /*食谱管理*/
    @RequestMapping("/recipe")
    public String recipe(){

        return "redirect:/recipe/define";
    }
    /*餐标管理*/
    @RequestMapping("/standard")
    public String standard(){

        return "redirect:/standard/define";
    }
    /*配送单管理*/
    @RequestMapping("/delivering")
    public String delivering(){

        return "redirect:/delivering/creat";
    }
    /*查询配送单*/
    @RequestMapping("/historydelivering")
    public String historyDelivering(){

        return "redirect:/historydelivering/history";
    }
    /*结算配送单*/
    @RequestMapping("/settledelivering")
    public String settleDelivering(){

        return "redirect:/settledelivering/all";
    }

}
