package com.example.tuancan.controller;

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

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
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

//    /*员工详情页面*/
//    @RequestMapping("/details")
//    public String getStaffDetails(DeliveringCompanyStaff deliveringCompanyStaff,Model model){
//
//        log.info("员工id:"+deliveringCompanyStaff.getDCompanyStaffId().toString());
//        DeliveringCompanyStaff deliveringCompanyStaff1 = deliveringCompanyStaffService.selectByIdWithCompany(deliveringCompanyStaff);
//        model.addAttribute("staff",deliveringCompanyStaff1);
//        return  "/groupmanager/staff_details";
//    }
}
