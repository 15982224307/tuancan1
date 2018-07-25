package com.example.tuancan.controller;

import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.service.DeliveringCompanyService;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/dc_details/{id}")
    public String dc_details(Model model, @PathVariable("id") Integer id){

        if (id==null){

            return "/manager/dc_update";

        }
        log.info("dcid:"+id);
        DeliveringCompany company = deliveringCompanyService.selectByIdWithGrade(id);
        log.info(JsonUtil.toJson(company));
        model.addAttribute("dc",company);

        return "/manager/dc_update";
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
            log.info("name:"+deliveringCompany.getDeliveringCompanyContact());
            int insertOne = deliveringCompanyService.updateOne(deliveringCompany);
            log.info(insertOne+"");
        }else {

        }
        return "ok";
       // return "forward:/deliveringCompany/yes_list";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(Model model,@RequestParam(name = "name") String name){

        log.info(name);
        List<DeliveringCompany> deliveringCompanies = deliveringCompanyService.selectAllByName(name);

        log.info(JsonUtil.toJson(deliveringCompanies));
        model.addAttribute("dclist",deliveringCompanies);

        return "/manager/dc_list :: #searchtable";
    }
}
