package com.example.tuancan.controller;

import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.service.DeliveringCompanyService;
import com.example.tuancan.utils.JsonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @RequestMapping(value = {"/yes_list/{pagenum}","/yes_list"})
    public String dcStausYeslist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<DeliveringCompany> deliveringCompanies = deliveringCompanyService.selectAllByStatus(StatusEnum.StatusUP.getCode());
        PageInfo<DeliveringCompany> pageInfo = new PageInfo<DeliveringCompany>(deliveringCompanies);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        //model.addAttribute("page",pageInfo);
        model.addAttribute("path","/deliveringCompany/yes_list");
        model.addAttribute("dclist",deliveringCompanies);
        return "/manager/dc_list";
    }

    @RequestMapping(value = {"/no_list/{pagenum}","/no_list"})
    public String dcStatusNolist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);

        List<DeliveringCompany> deliveringCompanies = deliveringCompanyService.selectAllByStatus(StatusEnum.StatusWait.getCode());
        PageInfo<DeliveringCompany> pageInfo = new PageInfo<DeliveringCompany>(deliveringCompanies);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        model.addAttribute("path","/deliveringCompany/no_list");
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
