package com.example.tuancan.service;

import com.example.tuancan.model.FoodMaterial;
import com.example.tuancan.model.Material;
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
public class MaterialServiceTest {

    @Autowired
    private MaterialService materialService;

    /*测试id查询*/
    @Test
    public void selectOneById() throws Exception {
        Material material = materialService.selectOneById(1);
        System.out.println(JsonUtil.toJson(material));
    }

    /*测试食谱id查询*/
    @Test
    public void selectOneByFoodId() throws Exception {
        List<Material> materials = materialService.selectOneByFoodId(2);
        System.out.println(JsonUtil.toJson(materials));
    }

    /*测试所有数据*/
    @Test
    public void getAll() throws Exception {
        List<Material> all = materialService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*测试食谱id查询
    * */
    @Test
    public void selectOneByRecipeId() throws Exception {
        List<Material> materials = materialService.selectOneByRecipeId(1);
        System.out.println(JsonUtil.toJson(materials));
    }

    /*测试插入*/
    @Test
    public void insertOne() throws Exception {
        FoodMaterial foodMaterial = new FoodMaterial();
        foodMaterial.setFoodmaterialId(2);
        Recipe recipe = new Recipe();
        recipe.setRecipeId(1);

        Material material = new Material();
        material.setFoodMaterial(foodMaterial);
        material.setRecipe(recipe);
        int i = materialService.insertOne(material);
        System.out.println(i);


    }

    /*测试更新*/
    @Test
    public void updateOne() throws Exception {
        Material material = materialService.selectOneById(2);
        material.setMaterialWeight(11);
        int i = materialService.updateOne(material);
        System.out.println(i);
    }

}