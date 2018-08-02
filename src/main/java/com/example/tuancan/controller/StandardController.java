package com.example.tuancan.controller;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.service.DiningStandardService;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.normalizer.UBiDiProps;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/standard")
public class StandardController {

    @Autowired
    private DiningStandardService diningStandardService;


    @RequestMapping("/define")
    public String defineStandard(HttpServletRequest httpServletRequest, Model model){
        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");
        List<DiningStandard> diningStandards = diningStandardService.selectAllByCompanyNo(companyId);
        model.addAttribute("standards",diningStandards);
        return "/groupmanager/standard";
    }

    @RequestMapping("/addstandard")
    public String addStandard(DiningStandard diningStandard, HttpServletRequest httpServletRequest){

        System.out.println(JsonUtil.toJson(diningStandard));
        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");
        DeliveringCompany deliveringCompany = new DeliveringCompany();
        deliveringCompany.setDeliveringCompanyNo(companyId);
        diningStandard.setDeliveringCompany(deliveringCompany);

        diningStandardService.InsertOne(diningStandard);

        return "redirect:/groupmanager/standard";
    }
    @RequestMapping("/updatestandard")
    public String updateStandard(DiningStandard diningStandard,HttpServletRequest httpServletRequest){
        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");
        DeliveringCompany deliveringCompany = new DeliveringCompany();
        deliveringCompany.setDeliveringCompanyNo(companyId);
        diningStandard.setDeliveringCompany(deliveringCompany);
        diningStandardService.UpdateOne(diningStandard);
        return "redirect:/groupmanager/standard";
    }
}
