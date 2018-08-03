package com.example.tuancan.controller;

import com.example.tuancan.service.DeliveringCompanyService;
import com.example.tuancan.service.DiningStandardService;
import com.example.tuancan.service.GroupMealContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author xiaoqy
 * @Date 2018/8/3
 * @Description
 */
@Controller
@Slf4j
@RequestMapping("groupMealContract")
public class GroupMealContractController {

    @Autowired
    private GroupMealContractService groupMealContractService;

    @Autowired
    private DeliveringCompanyService deliveringCompanyService;

    @Autowired
    private DiningStandardService diningStandardService;


    public String showContract(){

        return "";
    }

    @RequestMapping(value = "/",method = {RequestMethod.POST})
    public String  setContract(){

        return "";
    }
}
