package com.example.tuancan.service.impl;

import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.model.GroupMealContract;
import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.service.GroupMealContractService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupMealContractServiceimplTest {

    @Autowired
    private GroupMealContractService service;

    @Test
    public void selectOne() throws Exception {
        GroupMealContract groupMealContract = service.selectOneById(3);
        System.out.println(JsonUtil.toJson(groupMealContract));
    }

    @Test
    public void selectAll() throws Exception {
        List<GroupMealContract> groupMealContracts = service.selectAll();
        System.out.println(JsonUtil.toJson(groupMealContracts));
    }

    @Test
    public void selectByStatus() throws Exception {
        List<GroupMealContract> groupMealContracts = service.selectByStatus(1);
        System.out.println(JsonUtil.toJson(groupMealContracts));
    }

    @Test
    public void selectByExpireDate() throws Exception {
        List<GroupMealContract> groupMealContracts =
                service.selectByExpireDate();
        System.out.println(JsonUtil.toJson(groupMealContracts));
    }

    @Test
    public void insertOne() throws Exception {

        GroupMealContract groupMealContract = new GroupMealContract();

        DiningStandard standard = new DiningStandard();
        standard.setStandardId(1);
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(1);

        groupMealContract.setStandard(standard);
        groupMealContract.setGroupMealUnit(groupMealUnit);
        groupMealContract.setGMlContractName("合同");
        groupMealContract.setGMlContractDisc("描述");
//        groupMealContract.setGMlContractExpirydate(new Date());
        groupMealContract.setGMContractMeatnumber(5);
        groupMealContract.setGMlContractVegetablenumber(3);
        groupMealContract.setGMlContractStatus(1);
        groupMealContract.setGMContractSigndate(new Date());
        groupMealContract.setGMlContractGroupA("xiao");
        groupMealContract.setGMContractGroupB("wc");

        int i = service.insertOne(groupMealContract);
        System.out.println(i);
        System.out.println(JsonUtil.toJson(groupMealContract));
    }

    @Test
    public void updateOne() throws Exception {
        GroupMealContract groupMealContract = new GroupMealContract();

        DiningStandard standard = new DiningStandard();
        standard.setStandardId(1);
        GroupMealUnit groupMealUnit = new GroupMealUnit();
        groupMealUnit.setGroupMealUnitId(1);

        groupMealContract.setGMContractId(2);
        groupMealContract.setStandard(standard);
        groupMealContract.setGroupMealUnit(groupMealUnit);
        groupMealContract.setGMlContractName("update合同");
        groupMealContract.setGMlContractDisc("update描述");
//        groupMealContract.setGMlContractExpirydate(new Date());
        groupMealContract.setGMContractMeatnumber(5);
        groupMealContract.setGMlContractVegetablenumber(3);
        groupMealContract.setGMlContractStatus(1);
        groupMealContract.setGMContractSigndate(new Date());
        groupMealContract.setGMlContractGroupA("xiao");
        groupMealContract.setGMContractGroupB("wc");

        int i = service.updateOne(groupMealContract);
        System.out.println(i);
        System.out.println(JsonUtil.toJson(groupMealContract));
    }

}