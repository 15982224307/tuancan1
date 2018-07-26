package com.example.tuancan.controller;

import com.example.tuancan.model.RecipeType;
import com.example.tuancan.service.RecipeTypeService;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("recipeType")
public class RecipeTypeController {

    @Autowired
    private RecipeTypeService recipeTypeService;

    @RequestMapping(value = "/list")
    public String  rtlist(Model model){
        List<RecipeType> recipeTypes = recipeTypeService.selectOrderByCreateDateDESC();

        model.addAttribute("typelist",recipeTypes);

        return "/manager/rctype_list";
    }

//    @RequestMapping(value = "/detail/{id}")
//    public String  newordetail(Model model, @PathVariable(value = "id",required = false)Integer id){
//        if (id==null){
//            //添加页面
//            return "";
//        }else {
//            //详细
//            RecipeType recipeType = recipeTypeService.selectOneById(id);
//            model.addAttribute("typelist",recipeType);
//        }
//
//        return "/manager";
//    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public String  saveorupdate(Model model,RecipeType  recipeType){
        log.info(JsonUtil.toJson(recipeType));
        if (recipeType.getRecipeTypeId()!=null){
            //更新
            log.info("更新"+recipeType.getRecipeTypeId()+"");
            int updateOne = recipeTypeService.updateOne(recipeType);
            log.info(updateOne+"");
        }else {
            //新增
            int insertOne = recipeTypeService.insertOne(recipeType);
            log.info(insertOne+"");
        }

        return "ok";
    }
    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.POST})
    @ResponseBody
    public String  delete(Model model,@PathVariable("id") Integer id){
        log.info(id+"");
        int i = recipeTypeService.deleteOne(id);
        log.info("删除"+i);

        return "ok";
    }
    @RequestMapping(value = "/search")
    public String  search(Model model,@RequestParam(value = "typename",required = false) String typename){
        List<RecipeType> recipeTypes = recipeTypeService.selectByName(typename);

        model.addAttribute("typelist",recipeTypes);

        return "/manager/rctype_list :: #sshtml";
    }
}
