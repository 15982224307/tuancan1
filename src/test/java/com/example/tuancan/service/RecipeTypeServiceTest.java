package com.example.tuancan.service;

import com.example.tuancan.model.RecipeType;
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
public class RecipeTypeServiceTest {

    @Autowired
    private RecipeTypeService recipeTypeService;

    /*测试插入*/
    @Test
    public void insertOne() throws Exception {

        RecipeType recipeType = new RecipeType();
        recipeType.setRecipeTypeName("2");
        recipeType.setRecipeTypeDisc("4");
        int i = recipeTypeService.insertOne(recipeType);
        System.out.println(i);
    }

    /*测试更新*/
    @Test
    public void updateOne() throws Exception {
        RecipeType recipeType = recipeTypeService.selectOneById(2);
        recipeType.setRecipeTypeName("sxa");
        int i = recipeTypeService.updateOne(recipeType);
        System.out.println(i);
    }

    /*测试删除*/
    @Test
    public void deleteOne() throws Exception {
        int i = recipeTypeService.deleteOne(2);
        System.out.println(i);

    }

    /*根据id查询*/
    @Test
    public void selectOneById() throws Exception {
        RecipeType recipeType = recipeTypeService.selectOneById(1);
        System.out.println(JsonUtil.toJson(recipeType));
    }

    /*根据name查询*/
    @Test
    public void selectOneByName() throws Exception {
        RecipeType recipeType = recipeTypeService.selectOneByName("sxa");
        System.out.println(JsonUtil.toJson(recipeType));
    }

    /*得到所有数据*/
    @Test
    public void selectAll() throws Exception {
        List<RecipeType> recipeTypes = recipeTypeService.selectAll();
        System.out.println(JsonUtil.toJson(recipeTypes));
    }

    /*创建时间正序查询*/
    @Test
    public void selectOrderByCreateDateASC() throws Exception {
        List<RecipeType> recipeTypes = recipeTypeService.selectOrderByCreateDateASC();
        System.out.println(JsonUtil.toJson(recipeTypes));
    }

    /*创建时间倒序查询*/
    @Test
    public void selectOrderByCreateDateDESC() throws Exception {
        List<RecipeType> recipeTypes = recipeTypeService.selectOrderByCreateDateDESC();
        System.out.println(JsonUtil.toJson(recipeTypes));

    }

}