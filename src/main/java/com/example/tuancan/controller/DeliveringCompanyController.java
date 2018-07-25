package com.example.tuancan.controller;

import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.service.DeliveringCompanyService;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/deliveringCompany")
public class DeliveringCompanyController {

    @Autowired
    private DeliveringCompanyService deliveringCompanyService;

    @RequestMapping("/yes_list")
    public String dcStausYeslist(Model model){

        List<DeliveringCompany> deliveringCompanies = deliveringCompanyService.selectAllByStatus(StatusEnum.StatusUP.getCode());
        model.addAttribute("dclist",deliveringCompanies);
        return "/manager/dc_list";
    }

    @RequestMapping("/no_list")
    public String dcStatusNolist(Model model){

        List<DeliveringCompany> deliveringCompanies = deliveringCompanyService.selectAllByStatus(StatusEnum.StatusWait.getCode());
        List<DeliveringCompany> deliveringCompanies2 = deliveringCompanyService.selectAllByStatus(StatusEnum.StatusDOWN.getCode());

        deliveringCompanies.addAll(deliveringCompanies2);
        model.addAttribute("dclist",deliveringCompanies);
        return "/manager/dc_list";
    }

    @RequestMapping("/dc_details")
    public String dc_details(Model model,DeliveringCompany deliveringCompany){

        if (deliveringCompany.getDeliveringCompanyNo()==null){

            return "/manager/dc_newOrupdate";

        }
        log.info("dcid:"+deliveringCompany.getDeliveringCompanyNo());
        DeliveringCompany company = deliveringCompanyService.selectByIdWithGrade(deliveringCompany.getDeliveringCompanyNo());
        log.info(JsonUtil.toJson(company));
        model.addAttribute("dc",company);

        return "/manager/dc_newOrupdate";
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public String savedc(DeliveringCompany company){
        //更新
        log.info(JsonUtil.toJson(company));
        if (company.getDeliveringCompanyNo()!=null){
            DeliveringCompany deliveringCompany= deliveringCompanyService.selectByIdWithGrade(company.getDeliveringCompanyNo());
            deliveringCompany.setDeliveringCompanyTel(company.getDeliveringCompanyTel());
            deliveringCompany.setDeliveringCompanyBank(company.getDeliveringCompanyBank());
            deliveringCompany.setDeliveringCompanyContact(company.getDeliveringCompanyContact());

            int insertOne = deliveringCompanyService.updateOne(deliveringCompany);
            log.info(insertOne+"");
        }else {

        }
        return "ok";
       // return "forward:/deliveringCompany/yes_list";
    }
}
