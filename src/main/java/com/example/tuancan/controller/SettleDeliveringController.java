package com.example.tuancan.controller;

import com.example.tuancan.dto.DeliveringHistory;
import com.example.tuancan.model.DeliveringCompanyStaff;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.model.GroupMealContract;
import com.example.tuancan.service.DeliveringMasterService;
import com.example.tuancan.service.DiningStandardService;
import com.example.tuancan.service.GroupMealContractService;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
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


                List<DeliveringMaster> deliveringMasters = deliveringMasterService.selectByDeliverdate(unit_id, companyId);
                deliveringHistory.setDeliveringMasters(deliveringMasters);

                unit_Company.add(deliveringHistory);


            }
        }
        model.addAttribute("mealUnit",unit_Company);
//        System.out.println(JsonUtil.toJson(model));
        return "/groupmanager/settledelivering";
    }

    @CacheEvict
    @RequestMapping("/search")
    public String search(Model model,HttpServletRequest httpServletRequest, @Param("id")Integer id,
                         @Param("startTime1")String startTime1,@Param("endTime1")String endTime1){
        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");
        log.info("公司id：" + companyId + " id:" + id + " 开始时间：" + startTime1 + " 结束时间：" + endTime1);
        Date startTime = Date.valueOf(startTime1);
        Date endTime = Date.valueOf(endTime1);


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

                List<DeliveringMaster> deliveringMasters = deliveringMasterService.selectByUnitAndCompanyAndByDeliverdate(id,companyId,startTime,endTime);

                deliveringHistory.setDeliveringMasters(deliveringMasters);

                unit_Company.add(deliveringHistory);
            }
        }


        model.addAttribute("mealUnit",unit_Company);
        System.out.println(JsonUtil.toJson(model));

        return  "redirect:/groupmanager/settledelivering";
    }
}
