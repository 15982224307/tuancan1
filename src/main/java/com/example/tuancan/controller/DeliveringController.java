package com.example.tuancan.controller;

import com.example.tuancan.dto.RecipeAndQuantity;
import com.example.tuancan.dto.UnitAndOrder;
import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.*;
import com.example.tuancan.service.*;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.OrderListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("/delivering")
public class DeliveringController {
    @Autowired
    private DiningStandardService diningStandardService;

    @Autowired
    private DeliveringMasterService deliveringMasterService;

    @Autowired
    private DeliveringDetailService deliveringDetailService;

    @Autowired
    private GroupMealContractService groupMealContractService;

    @Autowired
    private OrderQuantityService orderQuantityService;
    @RequestMapping("/creat")
    public String creatDelivering(HttpServletRequest httpServletRequest, Model model){

        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");
        log.info("配送公司编号：" +companyId);
        List<DiningStandard> diningStandards = diningStandardService.selectAllByCompanyNo(companyId);

        List<UnitAndOrder> unit_Company = new ArrayList<>();

        for(DiningStandard standard : diningStandards){
            Integer standardId = standard.getStandardId();
            List<GroupMealContract> groupMealContracts = groupMealContractService.selectOneByReipeId(standardId);
            for(GroupMealContract groupMealContract : groupMealContracts){

                /*合同基本信息*/
                Integer unit_id = groupMealContract.getGroupMealUnit().getGroupMealUnitId();
                UnitAndOrder unitAndOrder = new UnitAndOrder();
                /*设置合同荤素数量*/
                int hun = groupMealContract.getGMContractMeatnumber();
                int su = groupMealContract.getGMlContractVegetablenumber();
                unitAndOrder.setHun_number(hun);
                unitAndOrder.setSu_number(su);
                unitAndOrder.setPrice(standard.getStandardPrice());
                /*设置公司信息*/
                unitAndOrder.setUnitID(unit_id);
                unitAndOrder.setUnitName(groupMealContract.getGroupMealUnit().getGroupMealUnitName());

                /*日期格式化*/
                DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = java.sql.Date.valueOf(bf.format(new Date()));
                List<RecipeAndQuantity> unitAndOrders = orderQuantityService.getUnitAndOrder(unit_id,date);

                 /*添加荤素菜*/
                List<RecipeAndQuantity> orderList = OrderListUtil.getOrderList(StatusEnum.Meat.getCode(), unitAndOrders);
                unitAndOrder.setHun_recipes(orderList);

                List<RecipeAndQuantity> orderList1 = OrderListUtil.getOrderList(StatusEnum.Vegetable.getCode(), unitAndOrders);
                unitAndOrder.setSu_recipes(orderList1);

                /*点餐人数*/
                int people = OrderListUtil.getPeopleNumber(unitAndOrders)/(hun + su);
                unitAndOrder.setPeople(people);

                /*配送单是否已经生成过了
                * 通过查询配送的配送日期是否和当前时间相等*/
                List<DeliveringMaster> deliveringMasters = deliveringMasterService.selectByUnitAndCompanyAndOrderByDeliverdate(unit_id, companyId);
                try {
                    if (deliveringMasters.get(0).getDeliveringMasterDelivedate().getDate() == new Date().getDate()) {
                        unitAndOrder.setIsCreat(1);
                    } else {
                        unitAndOrder.setIsCreat(0);
                    }
                }catch (Exception e){
                    log.info(e.getMessage());
                }

                unit_Company.add(unitAndOrder);
            }
        }
        model.addAttribute("mealUnit",unit_Company);
//        System.out.println(JsonUtil.toJson(model));
        return "/groupmanager/delivering";
    }

    @ResponseBody
    @RequestMapping("/sendunit")
    public String sendToUnit(HttpServletRequest httpServletRequest,@RequestParam("price") String price,
                             @RequestParam("recipe_ids") String recipe_ids,
                             @RequestParam("unit_id") Integer unit_id,
                             @RequestParam("people") Integer people,
                             @RequestParam("creater") String creater){
        log.info("单价：" + price + " ,菜谱id：" + recipe_ids + " ,用餐单位id：" + unit_id + " ,人数:" + people + " ,创建人："+creater);

        DeliveringMaster deliveringMaster = new DeliveringMaster();
        /*用餐单位编号*/
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(unit_id);
        deliveringMaster.setGroupMealUnit(groupMealUnit);
        /*配送单位编号 */
         DeliveringCompany deliveringCompany = new DeliveringCompany();
         deliveringCompany.setDeliveringCompanyNo((Integer)httpServletRequest.getSession().getAttribute("companyId"));
         deliveringMaster.setDeliveringCompany(deliveringCompany);
         /*配送日期*/
         deliveringMaster.setDeliveringMasterDelivedate(new Date());
         /*份数*/
         deliveringMaster.setDeliveringMasterAmount(people);
         deliveringMaster.setDeliveringMasterCreatedate(new Date());
         /*单价*/
         deliveringMaster.setDeliveringMasterPrice(BigDecimal.valueOf(Double.parseDouble(price)));
         /*备注*/
         deliveringMaster.setDeliveringMasterMemo("");
         /*创建人*/
         deliveringMaster.setDeliveringMasterCreater(creater);
         deliveringMasterService.insertOne(deliveringMaster);


         /*添加详情表*/

        return "5445";
    }
}
