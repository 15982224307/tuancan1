package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.model.TomorrowMenuMaster;
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
public class TomorrowMenuMasterServiceTest {

    @Autowired
    private TomorrowMenuMasterService tomorrowMenuMasterService;

    /*测试id查询*/
    @Test
    public void selectOneById() throws Exception {
        TomorrowMenuMaster tomorrowMenuMaster = tomorrowMenuMasterService.selectOneById(1);
        System.out.println(JsonUtil.toJson(tomorrowMenuMaster));
    }

    /*测试按单位id查询*/
    @Test
    public void selectByUnitId() throws Exception {
        List<TomorrowMenuMaster> tomorrowMenuMasters = tomorrowMenuMasterService.selectByUnitId(2);
        System.out.println(JsonUtil.toJson(tomorrowMenuMasters));
    }

    /*测试状态查询*/
    @Test
    public void selectByStatus() throws Exception {
        List<TomorrowMenuMaster> tomorrowMenuMasters = tomorrowMenuMasterService.selectByStatus(3);
        System.out.println(JsonUtil.toJson(tomorrowMenuMasters));
    }

    /*测试得到所有数据*/
    @Test
    public void getAll() throws Exception {
        List<TomorrowMenuMaster> all = tomorrowMenuMasterService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*插入数据*/
    @Test
    public void insertOne() throws Exception {
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(1);

        TomorrowMenuMaster tomorrowMenuMaster = new TomorrowMenuMaster();
        tomorrowMenuMaster.setGroupMealUnit(groupMealUnit);

        int i = tomorrowMenuMasterService.insertOne(tomorrowMenuMaster);
        System.out.println(i);
    }

    /*更新数据*/
    @Test
    public void updateOne() throws Exception {
        TomorrowMenuMaster tomorrowMenuMaster = tomorrowMenuMasterService.selectOneById(4);
        tomorrowMenuMaster.setTomorrowMenuMasterStatus(2);
        int i = tomorrowMenuMasterService.updateOne(tomorrowMenuMaster);
        System.out.println(i);
    }

    /*删除数据*/
    @Test
    public void deleteOne() throws Exception {
        int i = tomorrowMenuMasterService.deleteOne(4);
        System.out.println(i);
    }

}