package com.example.tuancan.service;

import com.example.tuancan.model.GtodMessage;
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
public class GtodMessageServiceTest {

    @Autowired
    private GtodMessageService gtodMessageService;

    /*测试状态查询*/
    @Test
    public void selectByStatus() throws Exception {
        List<GtodMessage> gtodMessages = gtodMessageService.selectByStatus(2);
        System.out.println(JsonUtil.toJson(gtodMessages));
    }

    /*测试unitid查询*/
    @Test
    public void selectByUnitId() throws Exception {
        List<GtodMessage> gtodMessages = gtodMessageService.selectByUnitId(11);
        System.out.println(JsonUtil.toJson(gtodMessages));
    }

    /*测试id查询*/
    @Test
    public void selectById() throws Exception {
        GtodMessage gtodMessage = gtodMessageService.selectById(2);
        System.out.println(JsonUtil.toJson(gtodMessage));
    }

    /*测试未读消息查询*/
    @Test
    public void selectNoReadByUnitId() throws Exception {
        List<GtodMessage> gtodMessages = gtodMessageService.selectNoReadByUnitId(0);
        System.out.println(JsonUtil.toJson(gtodMessages));
    }

    /*测试删除消息查询*/
    @Test
    public void deleteReaded() throws Exception {
        int i = gtodMessageService.deleteReaded();
    }

    /*测试更新状态*/
    @Test
    public void updateStatusById() throws Exception {
        int i = gtodMessageService.updateStatusById(2);
        System.out.println(i);
    }

    /*测试插入*/
    @Test
    public void insertOne() throws Exception {
        GtodMessage gtodMessage = new GtodMessage();
        gtodMessage.setGtodmessageStatus(1);
        int i = gtodMessageService.insertOne(gtodMessage);
        System.out.println(i);
    }

}