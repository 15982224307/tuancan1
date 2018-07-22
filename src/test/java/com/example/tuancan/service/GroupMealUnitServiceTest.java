package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupMealUnitServiceTest {

    @Autowired
    private GroupMealUnitService groupMealUnitService;

    /*测试查询一条数据*/
    @Test
    public void selectOneById() throws Exception {
        GroupMealUnit groupMealUnit = groupMealUnitService.selectOneById(2);
        System.out.println(JsonUtil.toJson(groupMealUnit));
    }

    /*测试通过名称查询*/
    @Test
    public void selectOneByName() throws Exception {
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectOneByName("abc");
        System.out.println(JsonUtil.toJson(groupMealUnits));
    }

    /*测试模糊查询*/
    @Test
    public void selectByLikeName() throws Exception {
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByLikeName("b");
        System.out.println(JsonUtil.toJson(groupMealUnits));
    }

    /*测试ticket查询*/
    @Test
    public void selectOneByTicket() throws Exception {
        GroupMealUnit groupMealUnits = groupMealUnitService.selectOneByTicket("ws");
        System.out.println(JsonUtil.toJson(groupMealUnits));
    }

    /*测试小于某个时间的数据*/
    @Test
    public void selectByReviewLtDate() throws Exception {
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByReviewLtDate(new Date());
        System.out.println(JsonUtil.toJson(groupMealUnits));
    }

    /*测试大于某个时间的数据*/
    @Test
    public void selectByReviewGtDate() throws Exception {
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByReviewGtDate(new Date());
        System.out.println(JsonUtil.toJson(groupMealUnits));
    }

    /*测试正序查询*/
    @Test
    public void selectByReviewTimeASC() throws Exception {
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByReviewTimeASC();
        System.out.println(JsonUtil.toJson(groupMealUnits));
    }

    /*测试倒序查询*/
    @Test
    public void selectByReviewTimeDESC() throws Exception {
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByReviewTimeDESC();
        System.out.println(JsonUtil.toJson(groupMealUnits));
    }

    /*测试查询所有数据*/
    @Test
    public void getAll() throws Exception {
        List<GroupMealUnit> all = groupMealUnitService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*测试删除一条数据*/
    @Test
    public void deleteOne() throws Exception {
        int i = groupMealUnitService.deleteOne(8);
        System.out.println(i);
    }

    /*测试根据状态查找数据*/
    @Test
    public void selectByStatus( ) {
        List<GroupMealUnit> groupMealUnits = groupMealUnitService.selectByStatus(1);
        System.out.println(JsonUtil.toJson(groupMealUnits));

    }
    /*测试增加一条数据*/
    @Test
    public void insertOne() throws Exception {
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitName("545");
        groupMealUnit.setGroupMealUnitContact("54558");
        int i = groupMealUnitService.insertOne(groupMealUnit);
        System.out.println(i);
    }

    /*测试修改数据*/
    @Test
    public void updateOne() throws Exception {
        GroupMealUnit groupMealUnit = groupMealUnitService.selectOneById(8);
        groupMealUnit.setGroupMealUnitName("wangchao");
        int i = groupMealUnitService.updateOne(groupMealUnit);
        System.out.println(i);

    }

}