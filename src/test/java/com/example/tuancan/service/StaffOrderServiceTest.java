package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.Recipe;
import com.example.tuancan.model.StaffOrder;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffOrderServiceTest {

    @Autowired
    private StaffOrderService staffOrderService;

    /*测试id查找*/
    @Test
    public void selectOneById() throws Exception {
        StaffOrder staffOrder = staffOrderService.selectOneById(1);
        System.out.println(JsonUtil.toJson(staffOrder));
    }

    @Test
    public void selectOneByStaffIdAnduseDate() throws Exception {
        /*格式化日期*/
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
        /*返回字符串，再转换为日期*/
        Date date = java.sql.Date.valueOf(bf.format(new Date()));

        List<StaffOrder> staffOrders = staffOrderService.selectOneByStaffIdAnduseDate(10, date);
        System.out.println(JsonUtil.toJson(staffOrders));


    }

    /*测试员工id查询点餐*/
    @Test
    public void selectOneByStaffId() throws Exception {
        List<StaffOrder> staffOrders = staffOrderService.selectOneByStaffId(3);
        System.out.println(JsonUtil.toJson(staffOrders));
    }

    /*测试通过食谱编号查找点餐*/
    @Test
    public void selectOneByRecipeId() throws Exception {
        List<StaffOrder> staffOrders = staffOrderService.selectOneByRecipeId(1);
        System.out.println(JsonUtil.toJson(staffOrders));
    }

    /*测试得到所有数据*/
    @Test
    public void getAll() throws Exception {
        List<StaffOrder> all = staffOrderService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*测试大于某个时间的数据*/
    @Test
    public void selectGtDateAll() throws Exception {
        Date date = new Date();
        List<StaffOrder> staffOrders = staffOrderService.selectGtDateAll(date);
        System.out.println(JsonUtil.toJson(staffOrders));
    }

    /*测试插入*/
    @Test
    public void insertOne() throws Exception {
        GroupMealStaff groupMealStaff = new GroupMealStaff();
        groupMealStaff.setGMStaffId(1);

        Recipe recipe = new Recipe();
        recipe.setRecipeId(1);

        StaffOrder staffOrder = new StaffOrder();
        staffOrder.setGMStaff(groupMealStaff);
        staffOrder.setRecipe(recipe);

        int i = staffOrderService.insertOne(staffOrder);
        System.out.println(i);

    }

    /*测试删除*/
    @Test
    public void deleteOne() throws Exception {
        int i = staffOrderService.deleteOne(3);
        System.out.println(i);
    }

    /*测试更新*/
    @Test
    public void updateOne() throws Exception {
        StaffOrder staffOrder = staffOrderService.selectOneById(3);
        staffOrder.setStaffOrderUsedate(new Date());
        int i = staffOrderService.updateOne(staffOrder);
        System.out.println(i);
    }

}