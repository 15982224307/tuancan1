package com.example.tuancan.service.impl;

import com.example.tuancan.model.GroupMealMenumaster;
import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.service.GroupMealMenumasterService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupMealMenumasterServiceImplTest {

    @Autowired
    private GroupMealMenumasterService service;

    @Test
    public void selectOneById() throws Exception {

        GroupMealMenumaster groupMealMenumaster = service.selectOneById(2);
        System.out.println(JsonUtil.toJson(groupMealMenumaster));
    }

    @Test
    public void selectByName() throws Exception {

        List<GroupMealMenumaster> groupMealMenumasters =
                service.selectByName("肉");
        System.out.println(JsonUtil.toJson(groupMealMenumasters));
    }

    @Test
    public void selectAllWithUnit() throws Exception {

        List<GroupMealMenumaster> groupMealMenumasters =
                service.selectAllWithUnit();
        System.out.println(JsonUtil.toJson(groupMealMenumasters));
    }
    @Test
    public void selectByUnitId() throws Exception {

        List<GroupMealMenumaster> groupMealMenumasters =
                service.selectByUnitId(3);
        System.out.println(JsonUtil.toJson(groupMealMenumasters));
    }

    @Test
    public void updateOne() throws Exception {

        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(3);

        GroupMealMenumaster groupMealMenumaster = new GroupMealMenumaster();
        groupMealMenumaster.setGroupMealMenumasterId(2);
        groupMealMenumaster.setGroupMealMenumasterName("jipai");
        groupMealMenumaster.setGroupMealUnit(groupMealUnit);

        int i = service.UpdateOne(groupMealMenumaster);
        System.out.println(i);
        System.out.println(JsonUtil.toJson(groupMealMenumaster));
    }

    @Test
    public void insertOne() throws Exception {
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(3);

        GroupMealMenumaster groupMealMenumaster = new GroupMealMenumaster();
        groupMealMenumaster.setGroupMealMenumasterName("红烧肉");
        groupMealMenumaster.setGroupMealUnit(groupMealUnit);

        int i = service.InsertOne(groupMealMenumaster);
        System.out.println(i);
        System.out.println(JsonUtil.toJson(groupMealMenumaster));
    }

}