package com.example.tuancan.controller;

import com.example.tuancan.dto.UnitAndStandard;
import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.*;
import com.example.tuancan.service.*;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.RecipeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.provider.Sun;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/unitmenu")
public class UnitMenuController {
    @Autowired
    private DiningStandardService diningStandardService;

    @Autowired
    private GroupMealUnitService groupMealUnitService;

    @Autowired
    private GroupMealContractService groupMealContractService;

    @Autowired
    private GroupMealMenumasterService groupMealMenumasterService;

    @Autowired
    private MenuDetailService menuDetailService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private TomorrowMenuMasterService tomorrowMenuMasterService;

    @Autowired
    private TomorrowMenuDetailService tomorrowMenuDetailService;

    /*跳转到为公司生成菜单页面
    * 此页面需要封装 公司信息，餐标信息，和根据自定义算法生成的菜谱*/
    @RequestMapping("/menu")
    public String menuAll(HttpServletRequest httpServletRequest, Model model){

        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");
        log.info("配送公司编号：" +companyId);
        List<DiningStandard> diningStandards = diningStandardService.selectAllByCompanyNo(companyId);
        List<UnitAndStandard> unit_Company = new ArrayList<>();
        for(DiningStandard standard : diningStandards){
            Integer standardId = standard.getStandardId();
            List<GroupMealContract> groupMealContracts = groupMealContractService.selectOneByReipeId(standardId);

            for(GroupMealContract groupMealContract : groupMealContracts){
                /*合同基本信息*/
                Integer unit_id = groupMealContract.getGroupMealUnit().getGroupMealUnitId();
                UnitAndStandard unitAndStandard = new UnitAndStandard();
                unitAndStandard.setDiningStandard(standard);
                /*荤菜个数*/
                int hun = groupMealContract.getGMContractMeatnumber();
                /*素菜个数*/
                int su = groupMealContract.getGMlContractVegetablenumber();
                unitAndStandard.setHun_number(hun);
                unitAndStandard.setSu_number(su);
                unitAndStandard.setUnitID(unit_id);
                unitAndStandard.setUnitName(groupMealContract.getGroupMealUnit().getGroupMealUnitName());

               /*采用自定义算法生成菜谱*/
//               /*盈利*/
                double profit = 0.5;
                BigDecimal standardPrice = standard.getStandardPrice();
//                /*除去利润的成本价*/
                BigDecimal bigDecimal = standardPrice.multiply(BigDecimal.valueOf(profit));
//                /*平均价格*/
                BigDecimal bigDecimal1 = BigDecimal.valueOf(hun + su);
                BigDecimal subtract = bigDecimal.divide(bigDecimal1,2);
//                /*生成荤菜*/
                List<Recipe> recipes1 = recipeService.selectByCompanyIdAndHunAndByPrice(companyId, subtract.add(BigDecimal.valueOf(1)));
//                /*生成素菜*/
                List<Recipe> recipes2 = recipeService.selectByCompanyIdAndBySuAndByPrice(companyId, subtract.subtract(BigDecimal.valueOf(1)));

                /*避免多次循环，使用工具类来对model 进行赋值*/
                unitAndStandard.setHun_recipe(RecipeUtil.getRecipes(recipes1));
                unitAndStandard.setSu_recipe(RecipeUtil.getRecipes(recipes2));

                unit_Company.add(unitAndStandard);
            }

        }


        model.addAttribute("mealUnit",unit_Company);
        return "/groupmanager/unitmenu";
    }



}
