package com.example.tuancan.controller;

import com.example.tuancan.dto.UnitAndStandard;
import com.example.tuancan.model.*;
import com.example.tuancan.service.*;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("tomorrowmenu")
public class TommorwMenuController {

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
                unitAndStandard.setHun_number(groupMealContract.getGMContractMeatnumber());
                unitAndStandard.setSu_number(groupMealContract.getGMlContractVegetablenumber());
                unitAndStandard.setUnitID(unit_id);
                unitAndStandard.setUnitName(groupMealContract.getGroupMealUnit().getGroupMealUnitName());

                /*荤素基本信息*/

                GroupMealMenumaster groupMealMenumaster = groupMealMenumasterService.selectByUnitId(unit_id);
                List<MenuDetail> menuDetails = menuDetailService.selectByMasterNo(groupMealMenumaster.getGroupMealMenumasterId());

                Map<Integer,String> huncai_number = new HashMap<>();
                Map<Integer,String> sucai_number = new HashMap<>();

//                /*循环得到餐谱细节 添加到具体的分类中*/
                for(MenuDetail menuDetail : menuDetails){
                    Recipe recipe = recipeService.selectOneById(menuDetail.getRecipe().getRecipeId());
                    if(recipe.getRecipeMeatOrVegetable() == 0){
                        huncai_number.put(recipe.getRecipeId(),recipe.getRecipeName());
                    }else{
                        sucai_number.put(recipe.getRecipeId(),recipe.getRecipeName());
                    }
                    unitAndStandard.setHuncai(huncai_number);
                    unitAndStandard.setSucai(sucai_number);
                }
                unit_Company.add(unitAndStandard);
                }
            }
        model.addAttribute("mealUnit",unit_Company);
        return "/groupmanager/tomorrowmenu";
    }

    @ResponseBody
    @RequestMapping("/addmenu")
    public String addMenu(@RequestParam("unitid")String unitid,@RequestParam("foodsid") String foodsid){
        log.info("用餐id:"+unitid +" foodsId:"+foodsid);
        String[] foods = foodsid.split(",");

        /*数据库的明日菜单主表的写入*/
        TomorrowMenuMaster tomorrowMenuMaster = new TomorrowMenuMaster();
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(Integer.parseInt(unitid));
        tomorrowMenuMaster.setGroupMealUnit(groupMealUnit);
        Date date = new Date();
        /*此处过期时间都是 设置为24小时的*/
        tomorrowMenuMaster.setTomorrowMenuMasterUsedate(new Date(date.getTime() +  +24*60*60*1000));
        tomorrowMenuMaster.setTomorrowMenuMasterExpiredate(new Date(date.getTime() +  +24*60*60*1000));
        tomorrowMenuMaster.setTomorrowMenuMasterStatus(1);
        tomorrowMenuMasterService.insertOne(tomorrowMenuMaster);


        /*这是明日菜单详情表的写入*/
        //要获取最新的数据的id用于 副表
        List<TomorrowMenuMaster> tomorrowMenuMasters = tomorrowMenuMasterService.selectByUnitId(Integer.parseInt(unitid));
        /*获取到的最新数据的id*/
        TomorrowMenuMaster tomorrowMenuMaster1 = tomorrowMenuMasters.get(0);
        TomorrowMenudetail tomorrowMenudetail = new TomorrowMenudetail();

        tomorrowMenudetail.setTomorrowMenuMaster(tomorrowMenuMaster1);

         /*遍历所有的食谱*/
         for (String food : foods){
             Recipe recipe = new Recipe();
             recipe.setRecipeId(Integer.parseInt(food));
             tomorrowMenudetail.setRecipe(recipe);

             double v = Math.random() * 10 + 1;
             /*随机推荐 ，有需要再更换*/
             if(v > 5){
                 tomorrowMenudetail.setTomorrowMenuIsRecommend(1);
             }
             else {
                 tomorrowMenudetail.setTomorrowMenuIsRecommend(0);
             }

             tomorrowMenuDetailService.insertOne(tomorrowMenudetail);
         }




        return "5255";
    }
}
