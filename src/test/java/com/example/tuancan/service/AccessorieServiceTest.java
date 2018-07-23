package com.example.tuancan.service;

import com.example.tuancan.model.Accessorie;
import com.example.tuancan.model.FoodMaterial;
import com.example.tuancan.model.Recipe;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessorieServiceTest {

    @Autowired
    private AccessorieService accessorieService;

    /*测试no查询*/
    @Test
    public void selectOneByNo() throws Exception {
        Accessorie accessorie = accessorieService.selectOneByNo(3);
        System.out.println(JsonUtil.toJson(accessorie));
    }

    /*测试所有数据*/
    @Test
    public void getAll() throws Exception {
        List<Accessorie> all = accessorieService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*测试食材id查询*/
    @Test
    public void selectOneByFoodId() throws Exception {
        List<Accessorie> accessories = accessorieService.selectOneByFoodId(1);
        System.out.println(JsonUtil.toJson(accessories));
    }

    /*测试食谱id查询*/
    @Test
    public void selectOneByRecipeId() throws Exception {
        List<Accessorie> accessories = accessorieService.selectOneByFoodId(1);
        System.out.println(JsonUtil.toJson(accessories));
    }

    /*测试插入*/
    @Test
    public void insertOne() throws Exception {
        FoodMaterial foodMaterial = new FoodMaterial();
        foodMaterial.setFoodmaterialId(2);
        Recipe recipe = new Recipe();
        recipe.setRecipeId(1);
        Accessorie accessorie = new Accessorie();
        accessorie.setFoodMaterial(foodMaterial);
        accessorie.setRecipe(recipe);
        int i = accessorieService.insertOne(accessorie);
        System.out.println(i);
    }

    @Test
    public void updateOne() throws Exception {
        Accessorie accessorie = accessorieService.selectOneByNo(1);
        accessorie.setAccessorieWeight("11");
        int i = accessorieService.updateOne(accessorie);
        System.out.println(i);
    }

}