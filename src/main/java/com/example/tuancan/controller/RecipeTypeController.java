package com.example.tuancan.controller;

import com.example.tuancan.model.RecipeType;
import com.example.tuancan.service.RecipeTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return "/manager/retype_list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String  newordetail(Model model, @PathVariable(value = "id",required = false)Integer id){
        if (id==null){
            //添加页面

            return "";
        }else {
            //详细
            RecipeType recipeType = recipeTypeService.selectOneById(id);
            model.addAttribute("typelist",recipeType);

        }

        return "/manager";
    }

    @RequestMapping(value = "/save")
    public String  saveorupdate(Model model,RecipeType  recipeType){
        if (recipeType.getRecipeTypeId()==null){
            //更新

        }else {
            //新增

        }

        return "/manager";
    }

    @RequestMapping(value = "/search")
    public String  search(Model model){
        List<RecipeType> recipeTypes = recipeTypeService.selectOrderByCreateDateDESC();

        model.addAttribute("typelist",recipeTypes);

        return "/manager/retype_list ::#";
    }
}
