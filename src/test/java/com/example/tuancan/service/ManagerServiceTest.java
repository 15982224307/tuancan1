package com.example.tuancan.service;

import com.example.tuancan.model.Manager;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;
    /*测试删除数据*/
    @Test
    public void deleteOne() throws Exception {
        int i = managerService.deleteOne(3);
        System.out.println(i);
    }

    /*测试插入数据*/
    @Test
    public void insertOne() throws Exception {
        Manager manager = new Manager();
        manager.setManagerLoginname("saa");
        manager.setManagerPassword("12");
        manager.setManagerName("wc");
        manager.setManagerStatus(0);
        int i = managerService.insertOne(manager);
        System.out.println(i);
    }

    /*测试更新数据*/
    @Test
    public void updateOne() throws Exception {

        Manager manager = managerService.selectOneByid(3);
        manager.setManagerLoginname("chao");
        int i = managerService.updateOne(manager);
        System.out.println(i);
    }

    @Test
    /*测试所有数据*/
    public void selectAll() throws Exception{
        List<Manager> managers = managerService.selectAll();
        System.out.println(JsonUtil.toJson(managers));

    }
    /*测试id查询*/
    @Test
    public void selectOneByid() throws Exception {
        Manager manager = managerService.selectOneByid(1);
        System.out.println(JsonUtil.toJson(manager));
    }

    /*测试name查询*/
    @Test
    public void selectOneByName() throws Exception {
        Manager manager = managerService.selectOneByName("san");
        System.out.println(JsonUtil.toJson(manager));
    }

    /*测试loginName查询*/
    @Test
    public void selectOneByLoginName() throws Exception {

        Manager ds = managerService.selectOneByLoginName("ds");
        System.out.println(JsonUtil.toJson(ds));
    }

    /*测试按状态查询*/
    @Test
    public void selectOneByStatus() throws Exception {

        List<Manager> managers = managerService.selectOneByStatus(1);
        System.out.println(JsonUtil.toJson(managers));
    }

}