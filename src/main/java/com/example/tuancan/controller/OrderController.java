package com.example.tuancan.controller;

import com.example.tuancan.convert.ConvertToCMV;
import com.example.tuancan.config.ProjectUrlConfig;
import com.example.tuancan.dto.CommendOrMealOrVegetable;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.TomorrowMenuMaster;
import com.example.tuancan.model.TomorrowMenudetail;
import com.example.tuancan.service.GroupMealStaffService;
import com.example.tuancan.service.RecipeService;
import com.example.tuancan.service.TomorrowMenuDetailService;
import com.example.tuancan.service.TomorrowMenuMasterService;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private GroupMealStaffService groupMealStaffService;

    @Autowired
    private TomorrowMenuDetailService tomorrowMenuDetailService;

    @Autowired
    private TomorrowMenuMasterService tomorrowMenuMasterService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    /*@Autowired
    private GroupMealMenumasterService groupMealMenumasterService;*/

    @RequestMapping("/get")
    //@ResponseBody
    public String index( HttpServletRequest request, Model model){
        /*Cookie cookie = CookieUtil.get(request, "openid");
        String openid = cookie.getValue();*/
        //session
        String openId = (String) request.getSession(true).getAttribute("openId");
        log.info("openid:"+openId);
        if (StringUtils.isEmpty(openId)){
            //没有openid 重新授权
            return "redirect:"+projectUrlConfig.getWhchatAuthorize()+"/wechat/authorize";
        }
        //查公司
        GroupMealStaff groupMealStaff = groupMealStaffService.selectByOpenid(openId);
        Integer unitId = groupMealStaff.getGroupMealUnitId().getGroupMealUnitId();

        //查明日菜单主表
        List<TomorrowMenuMaster> tomorrowMenuMasters = tomorrowMenuMasterService.selectByUnitIdAndUseDateAndExpireDate(unitId);

        Integer menuId=tomorrowMenuMasters.get(tomorrowMenuMasters.size()-1).getTomorrowMenuMasterId();
        log.info("menuId:"+menuId);

        //通过主表id 查明日菜单明细表
        List<TomorrowMenudetail> tomorrowMenudetails = tomorrowMenuDetailService.selectByMenuMasterId(menuId);

        log.info("明日荤素菜单明细");
        log.info(JsonUtil.toJson(tomorrowMenudetails));

        DeliveringCompany deliveringCompany=recipeService.selectOneById(tomorrowMenudetails.get(0).getRecipe().getRecipeId()).getDeliveringCompanyNo();

        //装配配推荐，荤素菜
        CommendOrMealOrVegetable commendOrMealOrVegetable = ConvertToCMV.convertCommendOrMealOrVegetable(tomorrowMenudetails,deliveringCompany, groupMealStaff.getGroupMealUnitId());

        log.info(JsonUtil.toJson(commendOrMealOrVegetable));


        model.addAttribute("cmv",commendOrMealOrVegetable);
        return "/webhtml/order";
        //return "redirect:"+projectUrlConfig.getWhchatAuthorize()+"/order/getMeal";
    }
/**前台数据
 * "commends": [
 {
 "recipeId": 1,
 "recipeName": "回锅肉",
 "recipeMaterial": "1",
 "recipeAccessorie": "1",
 "recipeProcessing": "1",
 "recipeMeatOrVegetable": 1,
 "recipeType": 1,
 "recipeIsCakes": 1,
 "recipeCharacter": "1",
 "recipePeople": "1",
 "recipeIcon": "1",
 "recipeCostprice": 1.00,
 "recipeStatus": 1,
 "recipeOwner": "1",
 "recipeCreatedate": "Jul 23, 2018 11:19:46 AM"
 }
 ],
 "meals": [
 {
 "recipeId": 1,
 "recipeName": "回锅肉",
 "recipeMaterial": "1",
 "recipeAccessorie": "1",
 "recipeProcessing": "1",
 "recipeMeatOrVegetable": 1,
 "recipeType": 1,
 "recipeIsCakes": 1,
 "recipeCharacter": "1",
 "recipePeople": "1",
 "recipeIcon": "1",
 "recipeCostprice": 1.00,
 "recipeStatus": 1,
 "recipeOwner": "1",
 "recipeCreatedate": "Jul 23, 2018 11:19:46 AM"
 }
 ],
 "veges": [
 {
 "recipeId": 3,
 "recipeName": "土豆丝",
 "recipeMeatOrVegetable": 2,
 "recipeType": 5,
 "recipeIsCakes": 2,
 "recipeCharacter": "2",
 "recipePeople": "2",
 "recipeIcon": "2",
 "recipeCostprice": 2.00,
 "recipeStatus": 2,
 "recipeOwner": "2",
 "recipeCreatedate": "Jul 23, 2018 1:16:38 PM"
 }
 ],
 "Unitname": "sanshe",
 "address": "西华大学",
 "tel": "012-4515",
 "staffName": "1"
 }
 */

}
