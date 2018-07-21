package com.example.tuancan.service.impl;

import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.service.GroupMealStaffService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupMealStaffServiceImplTest {

    @Autowired
    private GroupMealStaffService groupMealStaffService;

    /*测试查找*/
    @Test
    public void selectOneById() throws Exception {
        GroupMealStaff groupMealStaff = groupMealStaffService.selectOneById(1);
        System.out.println(JsonUtil.toJson(groupMealStaff));
    }

    /*测试查找所有*/
    @Test
    public void selectAll() throws Exception {
        List<GroupMealStaff> groupMealStaffs = groupMealStaffService.selectAll();
        System.out.println(JsonUtil.toJson(groupMealStaffs));
    }

    /*测试查找公司所有员工*/
    @Test
    public void selectByUnitId() throws Exception {
        List<GroupMealStaff> groupMealStaffs = groupMealStaffService.selectByUnitId(1);
        System.out.println(JsonUtil.toJson(groupMealStaffs));
    }

    /*测试通过name查找*/
    @Test
    public void selectByName() throws Exception {
        GroupMealStaff groupMealStaff = groupMealStaffService.selectByName("2");
        System.out.println(JsonUtil.toJson(groupMealStaff));
    }

    /*测试通过状态查找*/
    @Test
    public void selectByStatus() throws Exception {
        List<GroupMealStaff> groupMealStaffs = groupMealStaffService.selectByStatus(2);
        System.out.println(JsonUtil.toJson(groupMealStaffs));
    }

    /*测试通过是否默认状态查找*/
    @Test
    public void selectByIsDefault() throws Exception {
        List<GroupMealStaff> groupMealStaffs = groupMealStaffService.selectByIsDefault(1);
        System.out.println(JsonUtil.toJson(groupMealStaffs));

    }

    /*测试通过登录名查找*/
    @Test
    public void selectByLoginName() throws Exception {
        GroupMealStaff groupMealStaff = groupMealStaffService.selectByLoginName("2");
        System.out.println(JsonUtil.toJson(groupMealStaff));
    }

    /*测试通过openid查找*/
    @Test
    public void selectByOpenid() throws Exception {
        GroupMealStaff groupMealStaff = groupMealStaffService.selectByOpenid("2");
        System.out.println(JsonUtil.toJson(groupMealStaff));
    }

    /*测试通过ticket查找*/
    @Test
    public void selectByTicket() throws Exception {
        GroupMealStaff groupMealStaff = groupMealStaffService.selectByTicket("2");
        System.out.println(JsonUtil.toJson(groupMealStaff));
    }

    /*正序查找*/
    @Test
    public void selcetOrderByCreateTimeASC() throws Exception {
        List<GroupMealStaff> groupMealStaffs = groupMealStaffService.selcetOrderByCreateTimeASC();
        System.out.println(JsonUtil.toJson(groupMealStaffs));
    }

    /*逆序查找*/
    @Test
    public void selcetOrderByCreateTimeDESC() throws Exception {
        List<GroupMealStaff> groupMealStaffs = groupMealStaffService.selcetOrderByCreateTimeDESC();
        System.out.println(JsonUtil.toJson(groupMealStaffs));
    }

    /*测试插入*/
    @Test
    public void insertOne() throws Exception {
        GroupMealStaff groupMealStaff = new GroupMealStaff();
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(1);
        groupMealStaff.setGroupMealUnitId(groupMealUnit);
        int i = groupMealStaffService.insertOne(groupMealStaff);
        System.out.println(i);
    }

    /*测试删除*/
    @Test
    public void deleteOne() throws Exception {

        System.out.println(groupMealStaffService.deleteOne(12));

    }

    /*测试更新*/
    @Test
    public void updateOne() throws Exception {
        GroupMealStaff groupMealStaff = groupMealStaffService.selectOneById(11);
        groupMealStaff.setGMStaffName("ds1a");
        groupMealStaff.setGMStaffSex("nv");
        int i = groupMealStaffService.updateOne(groupMealStaff);
        System.out.println(i);
    }

}