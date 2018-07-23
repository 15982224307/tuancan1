package com.example.tuancan.controller;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.service.DeliveringCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    private DeliveringCompanyService deliveringCompanyService;

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
    @RequestMapping("/group/{grouparea}")
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

    @RequestMapping("/tuancan_list")
    public String dclist(Model model){

        List<DeliveringCompany> deliveringCompanies = deliveringCompanyService.selectAllWithGrade();
        model.addAttribute("dclist",deliveringCompanies);
        return "/manager/hy_list";
    }

}
