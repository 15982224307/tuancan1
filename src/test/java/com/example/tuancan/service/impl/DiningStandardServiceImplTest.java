package com.example.tuancan.service.impl;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.service.DiningStandardService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiningStandardServiceImplTest {

    @Autowired
    private DiningStandardService service;

    @Test
    public void selectOneWithCompany() throws Exception {

        DiningStandard diningStandard = service.selectOneWithCompany(1);
        System.out.println(JsonUtil.toJson(diningStandard));
    }

    @Test
    public void selectByPrice() throws Exception {
        List<DiningStandard> diningStandards = service.selectByPrice(new BigDecimal(16), new BigDecimal(3.5));
        System.out.println(JsonUtil.toJson(diningStandards));
    }

    @Test
    public void selectAllByCompanyNo() throws Exception {
        List<DiningStandard> diningStandards = service.selectAllByCompanyNo(1);
        System.out.println(JsonUtil.toJson(diningStandards));
    }

    @Test
    public void insertOne() throws Exception {
        DeliveringCompany deliveringCompany = new DeliveringCompany();
        deliveringCompany.setDeliveringCompanyNo(2);

        DiningStandard diningStandard = new DiningStandard();
        diningStandard.setDeliveringCompany(deliveringCompany);
        diningStandard.setStandardName("15快");
        diningStandard.setStandardMeatnumber(3);
        diningStandard.setStandardVegetablenumber(5);
        diningStandard.setStandardPrice(new BigDecimal(14.55));
        diningStandard.setStandardIsFreeDessert(0);
        diningStandard.setStandardIsFreeSoup(1);
        diningStandard.setStandardIsFreeFruit(0);


        int i = service.InsertOne(diningStandard);
        System.out.println(i);
        System.out.println(JsonUtil.toJson(diningStandard));
    }

    @Test
    public void updateOne() throws Exception {
        DeliveringCompany deliveringCompany = new DeliveringCompany();
        deliveringCompany.setDeliveringCompanyNo(1);

        DiningStandard diningStandard = new DiningStandard();
        diningStandard.setStandardId(2);
        diningStandard.setDeliveringCompany(deliveringCompany);
        diningStandard.setStandardName("15快");
        diningStandard.setStandardMeatnumber(5);
        diningStandard.setStandardVegetablenumber(5);
        diningStandard.setStandardPrice(new BigDecimal(15.55));
        diningStandard.setStandardIsFreeDessert(1);
        diningStandard.setStandardIsFreeSoup(1);
        diningStandard.setStandardIsFreeFruit(1);


        int i = service.UpdateOne(diningStandard);
        System.out.println(i);
        System.out.println(JsonUtil.toJson(diningStandard));
    }

}