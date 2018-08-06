package com.example.tuancan.controller;

import com.example.tuancan.dto.DeliveringHistory;
import com.example.tuancan.dto.RecipeAndQuantity;
import com.example.tuancan.dto.UnitAndOrder;
import com.example.tuancan.dto.UnitAndStandard;
import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.DeliveringDetail;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.model.GroupMealContract;
import com.example.tuancan.service.*;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.OrderListUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/historydelivering")
public class HistoryDeliveringController {
    @Autowired
    private DiningStandardService diningStandardService;

    @Autowired
    private DeliveringMasterService deliveringMasterService;

    @Autowired
    private DeliveringDetailService deliveringDetailService;

    @Autowired
    private GroupMealContractService groupMealContractService;


    @RequestMapping("/history")
    public String historyDelivering(Model model, HttpServletRequest httpServletRequest){

        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");
        log.info("配送公司编号：" +companyId);
        List<DiningStandard> diningStandards = diningStandardService.selectAllByCompanyNo(companyId);

        List<DeliveringHistory> unit_Company  = new ArrayList<>();

        for(DiningStandard standard : diningStandards){
            Integer standardId = standard.getStandardId();
            List<GroupMealContract> groupMealContracts = groupMealContractService.selectOneByReipeId(standardId);
            for(GroupMealContract groupMealContract : groupMealContracts){

                /*合同基本信息*/
                Integer unit_id = groupMealContract.getGroupMealUnit().getGroupMealUnitId();
                DeliveringHistory deliveringHistory = new DeliveringHistory();

                /*设置公司信息*/
                deliveringHistory.setUnitId(unit_id);
                deliveringHistory.setUnitName(groupMealContract.getGroupMealUnit().getGroupMealUnitName());

                List<DeliveringMaster> deliveringMasters = deliveringMasterService.selectByDeliverdate(unit_id, companyId);
                deliveringHistory.setDeliveringMasters(deliveringMasters);

                unit_Company.add(deliveringHistory);
            }
        }
        model.addAttribute("mealUnit",unit_Company);
//        System.out.println(JsonUtil.toJson(model));
        return "/groupmanager/history_delivering";
    }

    @RequestMapping("/getdetails")
    public String getDetails(@RequestParam("deliveringId")Integer deliveringId,Model model){
        log.info("详情编号：" + deliveringId);

        DeliveringMaster deliveringMaster = deliveringMasterService.selectOneById(deliveringId);

        List<DeliveringDetail> deliveringDetails = deliveringDetailService.selectByDeliveringMasterId(deliveringId);

        model.addAttribute("master",deliveringMaster);
        model.addAttribute("details",deliveringDetails);
//        System.out.println(JsonUtil.toJson(model));
        return "/groupmanager/delivering_details" ;
    }

}
