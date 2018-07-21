package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.model.TomorrowMenuMaster;
import com.example.tuancan.model.TomorrowMenudetail;
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
public class TomorrowMenuDetailServiceTest {

    @Autowired
    private TomorrowMenuDetailService tomorrowMenuDetailService;

    /*测试id查询*/
    @Test
    public void selectOneById() throws Exception {
        TomorrowMenudetail tomorrowMenudetail = tomorrowMenuDetailService.selectOneById(1);
        System.out.println(JsonUtil.toJson(tomorrowMenudetail));
    }

    /*测试单位编号查询*/
    @Test
    public void selectByUnitId() throws Exception {
        List<TomorrowMenudetail> tomorrowMenudetails = tomorrowMenuDetailService.selectByUnitId(1);
        System.out.println(JsonUtil.toJson(tomorrowMenudetails));
    }

    /*测试菜单编号查询*/
    @Test
    public void selectByMenuMasterId() throws Exception {
        List<TomorrowMenudetail> tomorrowMenudetails = tomorrowMenuDetailService.selectByMenuMasterId(2);
        System.out.println(JsonUtil.toJson(tomorrowMenudetails));
    }

    /*测试是否是推荐查询*/
    @Test
    public void selectByStatus() throws Exception {
        List<TomorrowMenudetail> tomorrowMenudetails = tomorrowMenuDetailService.selectByRecommend(2);
        System.out.println(JsonUtil.toJson(tomorrowMenudetails));
    }

    /*所有数据*/
    @Test
    public void getAll() throws Exception {
        List<TomorrowMenudetail> all = tomorrowMenuDetailService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*插入数据*/
    @Test
    public void insertOne() throws Exception {
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(1);
        TomorrowMenuMaster tomorrowMenuMaster = new TomorrowMenuMaster();
        tomorrowMenuMaster.setTomorrowMenuMasterId(1);

        TomorrowMenudetail tomorrowMenudetail = new TomorrowMenudetail();
        tomorrowMenudetail.setGroupMealUnit(groupMealUnit);
        tomorrowMenudetail.setTomorrowMenuMaster(tomorrowMenuMaster);
        int i = tomorrowMenuDetailService.insertOne(tomorrowMenudetail);
        System.out.println(i);
    }

    /*删除数据*/
    @Test
    public void deleteOne() throws Exception {
        int i = tomorrowMenuDetailService.deleteOne(3);
        System.out.println(i);

    }

    /*更新数据*/
    @Test
    public void updateOne() throws Exception {
        TomorrowMenudetail tomorrowMenudetail = tomorrowMenuDetailService.selectOneById(3);
        tomorrowMenudetail.setTomorrowMenuMemo("ds");
        int i = tomorrowMenuDetailService.updateOne(tomorrowMenudetail);
        System.out.println(i);
    }

}