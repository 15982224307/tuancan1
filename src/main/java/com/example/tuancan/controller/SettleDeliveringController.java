package com.example.tuancan.controller;

import com.example.tuancan.dto.DeliveringHistory;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.model.GroupMealContract;
import com.example.tuancan.service.DeliveringDetailService;
import com.example.tuancan.service.DeliveringMasterService;
import com.example.tuancan.service.DiningStandardService;
import com.example.tuancan.service.GroupMealContractService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/settledelivering")
public class SettleDeliveringController {

    @Autowired
    private DiningStandardService diningStandardService;

    @Autowired
    private DeliveringMasterService deliveringMasterService;

    @Autowired
    private GroupMealContractService groupMealContractService;


    @RequestMapping("/all")
    public String settleDelivering(Model model, HttpServletRequest httpServletRequest){

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

                unit_Company.add(deliveringHistory);
            }
        }
        model.addAttribute("mealUnit",unit_Company);
//        System.out.println(JsonUtil.toJson(model));
        return "/groupmanager/settledelivering";
    }
}
