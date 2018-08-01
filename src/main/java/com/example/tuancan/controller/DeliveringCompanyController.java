package com.example.tuancan.controller;

import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.service.DeliveringCompanyService;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
        PageUtil.setPageModel(model,pageInfo,"/deliveringCompany/yes_list");

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

        PageUtil.setPageModel(model,pageInfo,"/deliveringCompany/no_list");
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

    @RequestMapping("/status/{id}")
    @ResponseBody
    public String updatestatus(@PathVariable("id")Integer id,@RequestParam("status")Integer status){
        log.info(id+">>>>"+status);
        int i = deliveringCompanyService.updateStatusById(id, status);
        return "ok";
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
            //........
            log.info("name:"+deliveringCompany.getDeliveringCompanyContact());
            int insertOne = deliveringCompanyService.updateOne(deliveringCompany);
            log.info(insertOne+"");
        }else {

        }
        return "ok";
       // return "forward:/deliveringCompany/yes_list";
    }

    @RequestMapping(value = {"/search/{name}","/search/{name}/{pagenum}"},method = {RequestMethod.POST,RequestMethod.GET})
    public String search(Model model, @PathVariable(value = "name",required = false) String name,
                         @PathVariable(value = "pagenum",required = false) Integer pageNum,
                         @RequestParam(value = "asyc",required = false,defaultValue = "false")Boolean asyc){

        log.info(name);
        //PageUtil.checkPageNumAndCriteria(pageNum,name);
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        if (StringUtils.isEmpty(name)||name.equals("*")){
            name="";
        }
        String decode=null;
        String encode=null;
        try {
            decode= URLDecoder.decode(name, "utf-8");
            decode= URLDecoder.decode(decode, "utf-8");
            encode = URLEncoder.encode(decode,"utf-8");
            encode = URLEncoder.encode(encode,"utf-8");
            log.info(encode+"++"+decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<DeliveringCompany> deliveringCompanies = deliveringCompanyService.selectAllByName(name);
        PageInfo<DeliveringCompany> pageInfo = new PageInfo<DeliveringCompany>(deliveringCompanies);
        log.info(JsonUtil.toJson(deliveringCompanies));

        PageUtil.setPageModel(model,pageInfo,"/deliveringCompany/search/"+encode);
        model.addAttribute("dclist",deliveringCompanies);
        if (!asyc){
            return "/manager/dc_list";
        }
        return "/manager/dc_list :: #searchtable";
    }
}
