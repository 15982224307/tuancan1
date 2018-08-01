package com.example.tuancan.controller;

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
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeTypeService recipeTypeService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private AccessorieService accessorieService;

    @Autowired
    private FoodMaterialService foodMaterialService;

    /*进入添加食谱页面
    * 封装所需要的数据*/
    @RequestMapping("/define")
    public String recipeDefine( HttpServletRequest httpServletRequest,Model model){

        log.info("公司id:"+ httpServletRequest.getSession().getAttribute("companyId"));
        List<RecipeType> recipeTypes = recipeTypeService.selectAll();
        /*添加到model中*/
        model.addAttribute("recipelist",recipeTypes);
        return "/groupmanager/recipe";
    }

    @RequestMapping("/addrecipe")
    public String addRecipe(Recipe recipe, @RequestParam("type") String type,HttpServletRequest httpServletRequest){

        /*插入数据到食谱中*/
        RecipeType recipeType = new RecipeType();
        recipeType.setRecipeTypeId(Integer.parseInt(type));
        DeliveringCompany deliveringCompany = new DeliveringCompany();
        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute("companyId");
        deliveringCompany.setDeliveringCompanyNo(companyId);
        recipe.setRecipeTypeId(recipeType);
        recipe.setDeliveringCompanyNo(deliveringCompany);
        recipeService.insertOne(recipe);
        /*得到编号*/
        Recipe recipe1 = recipeService.selectByCompanyIdAndName(companyId, recipe.getRecipeName());
        Integer recipeId = recipe1.getRecipeId();

        /*原料编号*/
        String recipeMaterial = recipe1.getRecipeMaterial();
        String[] split = recipeMaterial.split(",");

        for(int i = 0;i<split.length ;i++){
            Material material = new Material();
            int i1 = Integer.parseInt(split[i]);
            FoodMaterial foodMaterial = foodMaterialService.selectOneById(i1);
            material.setFoodMaterial(foodMaterial);
            material.setRecipe(recipe1);
            material.setMaterialNo(new Date().getDate());
            materialService.insertOne(material);
        }

        /*辅料编号*/
        String recipeAccessorie = recipe1.getRecipeAccessorie();
        String[] split1 = recipeAccessorie.split(",");

        for(int i = 0;i<split1.length ;i++){
            Accessorie accessorie = new Accessorie();
            int i1 = Integer.parseInt(split[i]);
            FoodMaterial foodMaterial = foodMaterialService.selectOneById(i1);
            accessorie.setFoodMaterial(foodMaterial);
            accessorie.setRecipe(recipe1);
            accessorie.setAccessorieNo(new Date().getDate());

            accessorieService.insertOne(accessorie);
        }


        return "redirect:/groupmanager/recipe";
    }
}
