package com.example.tuancan.controller;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DeliveringCompanyStaff;
import com.example.tuancan.service.DeliveringCompanyStaffService;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/companystaff")
public class DeliveringCompanyStaffControl {

    @Autowired
    private DeliveringCompanyStaffService deliveringCompanyStaffService;

    /*跳转到员工列表页面*/
    @RequestMapping("/manager")
    public String getAllStaff(Model model, HttpServletRequest httpServletRequest){

       Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");

        List<DeliveringCompanyStaff> deliveringCompanyStaffs = deliveringCompanyStaffService.selectAllByCompanyNo(2);
        model.addAttribute("staff_list",deliveringCompanyStaffs);

        return "/groupmanager/companystaff_list";
    }

    /*查询*/
    @RequestMapping("/search")
    public String searchStaffs(@RequestParam("id")Integer id,@RequestParam("name")String name,Model model){

        log.info("公司id:"+id + "账号:" + name);
        List<DeliveringCompanyStaff> deliveringCompanyStaffs = deliveringCompanyStaffService.selecyStaffByLikeName(id, name);

        model.addAttribute("staff_list",deliveringCompanyStaffs);
        return  "/groupmanager/companystaff_list :: #table_staff";
    }
    /*添加员工*/
    @RequestMapping("/addstaff")
    public String addStaff(@RequestParam("id")Integer id,@RequestParam("zhiwu")String zhiwu,@RequestParam("name")String name,Model model){
        log.info("公司id:"+ id + " name:"+name + " 职务:" + zhiwu);

        DeliveringCompany deliveringCompany = new DeliveringCompany();
        deliveringCompany.setDeliveringCompanyNo(id);

        DeliveringCompanyStaff deliveringCompanyStaff = new DeliveringCompanyStaff();
        deliveringCompanyStaff.setDeliveringCompany(deliveringCompany);
        deliveringCompanyStaff.setDCompanyStaffLoginname(name);
        deliveringCompanyStaff.setDCompanyStaffPassword("000000");
        deliveringCompanyStaff.setDCompanyStaffMobile(name);
        deliveringCompanyStaff.setDCompanyStaffPosition(zhiwu);
        deliveringCompanyStaff.setDCompanyStaffDefault(1);
        deliveringCompanyStaff.setDCompanyStaffStatus(1);
        deliveringCompanyStaffService.insertOne(deliveringCompanyStaff);

        return "redirect:/companystaff/manager";
    }
}
