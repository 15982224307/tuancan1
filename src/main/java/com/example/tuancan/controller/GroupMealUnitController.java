package com.example.tuancan.controller;

import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.service.GroupMealUnitService;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@RequestMapping("/groupMealUnit")
@Slf4j
@Controller
public class GroupMealUnitController {

    @Autowired
    private GroupMealUnitService groupMealUnitService;

    @RequestMapping(value = {"/yes_list/{pagenum}","/yes_list"})
    public String dcStausYeslist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByStatus(StatusEnum.StatusUP.getCode());
        PageInfo<GroupMealUnit> pageInfo = new PageInfo<GroupMealUnit>(groupMealUnits);

        log.info(JsonUtil.toJson(groupMealUnits));

        PageUtil.setPageModel(model,pageInfo,"/groupMealUnit/yes_list");
        model.addAttribute("gmulist",groupMealUnits);
        return "/manager/gmu_list";
    }

    @RequestMapping(value = {"/no_list/{pagenum}","/no_list"})
    public String dcStatusNolist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByStatus(StatusEnum.StatusWait.getCode());
        PageInfo<GroupMealUnit> pageInfo = new PageInfo<GroupMealUnit>(groupMealUnits);

        log.info(JsonUtil.toJson(groupMealUnits));
        PageUtil.setPageModel(model,pageInfo,"/groupMealUnit/no_list");

        return "/manager/gmu_list";
    }

    @RequestMapping("/gmu_details/{unitId}")
    public String dc_details(Model model, @PathVariable("unitId") Integer unitId){
        if (unitId==null){
            return "/manager/gmu_update";

        }else {
            log.info(""+unitId);
            GroupMealUnit groupMealUnit = groupMealUnitService.selectOneById(unitId);
            model.addAttribute("unitVO",groupMealUnit);
            return "/manager/gmu_update";

        }

    }

    @RequestMapping("/status/{id}")
    @ResponseBody
    public String updatestatus(@PathVariable("id")Integer id,@RequestParam("status")Integer status){
        log.info(id+">>>>"+status);
        int i = groupMealUnitService.updateStatusById(id, status);
        return "ok";
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public String savedc(GroupMealUnit unit){
        //更新
        if (unit.getGroupMealUnitId()==null){
            return "error";
        }else {
            log.info(JsonUtil.toJson(unit));
            GroupMealUnit groupMealUnit = groupMealUnitService.selectOneById(unit.getGroupMealUnitId());
            groupMealUnit.setGroupMealUnitContact(unit.getGroupMealUnitContact());
            groupMealUnit.setGroupMealUnitName(unit.getGroupMealUnitName());
            //........平台没有修改内容权利
            log.info(JsonUtil.toJson(groupMealUnit));
            int i = groupMealUnitService.updateOne(groupMealUnit);
            log.info(i+"");
        }
        return "ok";
        // return "forward:/deliveringCompany/yes_list";
    }

    @RequestMapping(value = {"/search/{name}","/search/{name}/{pagenum}"},method = {RequestMethod.POST,RequestMethod.GET})
    public String search(Model model, @PathVariable(value = "name",required = false) String name,
                         @PathVariable(value = "pagenum",required = false) Integer pageNum,
                         @RequestParam(value = "asyc",required = false,defaultValue = "false")Boolean asyc){
        log.info(name);
        //PageUtil.checkPageNumAndCriteria(pageNum,name);
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        if (StringUtils.isEmpty(name)||name.equals("*")){
            name="";
        }
        String decode=null;
        String encode=null;
        try {
            decode= URLDecoder.decode(name, "utf-8");
            decode= URLDecoder.decode(decode, "utf-8");
            encode = URLEncoder.encode(decode,"utf-8");
            encode = URLEncoder.encode(encode,"utf-8");
            log.info("++"+decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByLikeName(name);
        PageInfo<GroupMealUnit> pageInfo = new PageInfo<GroupMealUnit>(groupMealUnits);

        log.info(JsonUtil.toJson(groupMealUnits));
        PageUtil.setPageModel(model,pageInfo,"/groupMealUnit/search/"+encode);

        model.addAttribute("gmulist",groupMealUnits);
        if (!asyc){
            return "/manager/gmu_list";
        }
        return "/manager/gmu_list :: #searchtable";
    }
}


