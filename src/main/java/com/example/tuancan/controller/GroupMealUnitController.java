package com.example.tuancan.controller;

import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.service.GroupMealUnitService;
import com.example.tuancan.utils.JsonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        model.addAttribute("path","/groupMealUnit/yes_list");
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
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        model.addAttribute("path","/groupMealUnit/no_list");
        model.addAttribute("gmulist",groupMealUnits);

        return "/manager/gmu_list";
    }

    @RequestMapping("/gmu_details/{unitId}")
    public String dc_details(Model model, @PathVariable("unitId") Integer unitId){
        if (unitId==null){
            return "/manager/gmu_update";

        }else {
            log.info(""+unitId);
            GroupMealUnit groupMealUnit = groupMealUnitService.selectOneById(unitId);
            model.addAttribute("unit",groupMealUnit);
            return "/manager/gmu_update";

        }

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

            log.info(JsonUtil.toJson(groupMealUnit));
            int i = groupMealUnitService.updateOne(groupMealUnit);
            log.info(i+"");
        }
        return "ok";
        // return "forward:/deliveringCompany/yes_list";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(Model model,@RequestParam(name = "groupMealUnitName") String groupMealUnitName){

        log.info(groupMealUnitName);
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByLikeName(groupMealUnitName);
        log.info(JsonUtil.toJson(groupMealUnits));
        model.addAttribute("gmulist",groupMealUnits);

        return "/manager/gmu_list :: #searchtable";
    }
}


