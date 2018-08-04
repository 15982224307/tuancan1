package com.example.tuancan.service;

import com.example.tuancan.dto.RecipeAndQuantity;
import com.example.tuancan.dto.UnitAndOrder;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderQuantityServiceTest {
    @Autowired
    private OrderQuantityService orderQuantityService;
    @Test
    public void getUnitAndOrder() throws Exception {

        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = java.sql.Date.valueOf(bf.format(new Date()));
        List<RecipeAndQuantity> unitAndOrders = orderQuantityService.getUnitAndOrder(1,date);
        System.out.println(JsonUtil.toJson(unitAndOrders));
    }

}