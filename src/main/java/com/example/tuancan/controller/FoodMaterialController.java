package com.example.tuancan.controller;

import com.example.tuancan.model.FoodMaterial;
import com.example.tuancan.service.FoodMaterialService;
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

@Controller
@Slf4j
@RequestMapping("foodMaterial")
public class FoodMaterialController {

    @Autowired
    private FoodMaterialService foodMaterialService;

    @RequestMapping(value = {"/list/{pagenum}","/list"})
    public String  rtlist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<FoodMaterial> foodMaterials = foodMaterialService.getAll();
        PageInfo<FoodMaterial> pageInfo = new PageInfo<FoodMaterial>(foodMaterials);

        log.info(pageInfo.getPages()+"xx"+pageInfo.getNextPage()+"xx"+
                pageInfo.isIsFirstPage()+pageInfo.isHasPreviousPage());
        log.info(JsonUtil.toJson(page.getResult()));
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
        //分页访问路径路径
        model.addAttribute("path","/foodMaterial/list");

        model.addAttribute("page",pageInfo);
        return "/manager/foodma_list";
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
    public String  saveorupdate(Model model,FoodMaterial  foodMaterial){
        log.info(JsonUtil.toJson(foodMaterial));
        if (foodMaterial.getFoodmaterialId()!=null){
            //更新

        }else {
            //新增
            int insertOne = foodMaterialService.insertOne(foodMaterial);
            log.info(insertOne+"");
        }

        return "ok";
    }
    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.POST})
    @ResponseBody
    public String  delete(Model model,@PathVariable("id") Integer id){
        log.info(id+"");

        return "ok";
    }
    @RequestMapping(value = "/search")
    public String  search(Model model,@RequestParam(value = "typename",required = false) String typename){
        List<FoodMaterial> foodMaterials = foodMaterialService.selectByName(typename);
        model.addAttribute("typelist",foodMaterials);

        return "/manager/rctype_list :: #sshtml";
    }

}
