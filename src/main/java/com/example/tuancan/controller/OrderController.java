package com.example.tuancan.controller;

import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.TomorrowMenuMaster;
import com.example.tuancan.model.TomorrowMenudetail;
import com.example.tuancan.service.GroupMealStaffService;
import com.example.tuancan.service.TomorrowMenuDetailService;
import com.example.tuancan.service.TomorrowMenuMasterService;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    /*@Autowired
    private GroupMealMenumasterService groupMealMenumasterService;*/

    @RequestMapping("/{openId}")
    @ResponseBody
    public String index(@PathVariable(name = "openId")String openId, HttpServletRequest request, HttpServletResponse response){
        /*Cookie cookie = CookieUtil.get(request, "openid");
        String openid = cookie.getValue();*/
        log.info("openid:"+openId);
        if (StringUtils.isEmpty(openId)){
            //没有openid 重新授权
            return "redirect:http://95ti4r.natappfree.cc/wechat/authorize";
        }
        //查公司
        GroupMealStaff groupMealStaff = groupMealStaffService.selectByOpenid(openId);
        Integer unitId = groupMealStaff.getGroupMealUnitId().getGroupMealUnitId();

        //查明日菜单主表
        List<TomorrowMenuMaster> tomorrowMenuMasters = tomorrowMenuMasterService.selectByUnitId(unitId);

        //通过主表id 查明日菜单明细表
        List<TomorrowMenudetail> tomorrowMenudetails = tomorrowMenuDetailService.selectByMenuMasterId(12);

        log.info("明日菜单明细");
        log.info(JsonUtil.toJson(tomorrowMenudetails));



        return "ok";
    }


    @RequestMapping(value = "/getMeal",method = {RequestMethod.GET,RequestMethod.POST})
    public String getMeal(){

        return "";
    }
}
