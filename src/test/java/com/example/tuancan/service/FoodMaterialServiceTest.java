package com.example.tuancan.service;

import com.example.tuancan.model.FoodMaterial;
import com.example.tuancan.utils.JsonUtil;
import netscape.javascript.JSUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.plugin.dom.DOMObject;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodMaterialServiceTest {

    @Autowired
    private FoodMaterialService foodMaterialService;

    /*测试id查询*/
    @Test
    public void selectOneById() throws Exception {
        FoodMaterial foodMaterial = foodMaterialService.selectOneById(1);
        System.out.println(JsonUtil.toJson(foodMaterial));
    }

    /*测试类查询*/
    @Test
    public void selectByClassId() throws Exception {
        List<FoodMaterial> foodMaterials = foodMaterialService.selectByClassId(1);
        System.out.println(JsonUtil.toJson(foodMaterials));
    }

    /*测试所有数据*/
    @Test
    public void getAll() throws Exception {
        List<FoodMaterial> all = foodMaterialService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*测试插入数据*/
    @Test
    public void insertOne() throws Exception {
    }

}