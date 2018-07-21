package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealMenumaster;
import com.example.tuancan.model.MenuDetail;
import com.example.tuancan.model.Recipe;
import com.example.tuancan.utils.JsonUtil;
import org.apache.ibatis.annotations.Insert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuDetailServiceTest {

    @Autowired
    private MenuDetailService menuDetailService;

    /*测试菜单编号查询*/
    @Test
    public void selectByMasterNo() throws Exception {
        List<MenuDetail> menuDetails = menuDetailService.selectByMasterNo(1);
        System.out.println(JsonUtil.toJson(menuDetails));
    }

    /*测试食谱编号查询*/
    @Test
    public void selectByRecipeNo() throws Exception {
        List<MenuDetail> menuDetails = menuDetailService.selectByRecipeNo(3);
        System.out.println(JsonUtil.toJson(menuDetails));
    }

    /*菜单和食谱对应查询*/
    @Test
    public void selectByRecipeNoAndMasterNo() throws Exception {
        MenuDetail menuDetail = menuDetailService.selectByRecipeNoAndMasterNo(1,3);
        System.out.println(JsonUtil.toJson(menuDetail));

    }

    /*测试菜单序号查询*/
    @Test
    public void selectByDetailId() throws Exception {
        List<MenuDetail> menuDetails = menuDetailService.selectByDetailId(2);
        System.out.println(JsonUtil.toJson(menuDetails));
    }

    /*测试插入数据*/
    @Test
    public void insertOne() throws Exception {
        GroupMealMenumaster groupMealMenumaster = new GroupMealMenumaster();
        groupMealMenumaster.setGroupMealMenumasterId(3);

        Recipe recipe = new Recipe();
        recipe.setRecipeId(1);

        MenuDetail menuDetail = new MenuDetail();
        menuDetail.setGroupMealMenumaster(groupMealMenumaster);
        menuDetail.setRecipe(recipe);
        int i = menuDetailService.insertOne(menuDetail);
        System.out.println(i);
    }

    /*测试更新数据*/
    @Test
    public void updateOne() throws Exception {
        MenuDetail menuDetail = menuDetailService.selectByRecipeNoAndMasterNo(1, 3);
        menuDetail.setMenuDetailMome("666");
        int i = menuDetailService.updateOne(menuDetail);
        System.out.println(i);

    }


    /*测试删除数据*/
    @Test
    public void deleteOne() throws Exception {
        MenuDetail menuDetail = menuDetailService.selectByRecipeNoAndMasterNo(3, 1);
        int i = menuDetailService.deleteOne(menuDetail);
        System.out.println(i);
    }

}