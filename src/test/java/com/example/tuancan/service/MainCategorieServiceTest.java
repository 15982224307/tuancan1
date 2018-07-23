package com.example.tuancan.service;

import com.example.tuancan.model.MainCategorie;
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
public class MainCategorieServiceTest {

    @Autowired
    private MainCategorieService mainCategorieService;

    /*测试所有数据*/
    @Test
    public void getAll() throws Exception {
        List<MainCategorie> all = mainCategorieService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*测试id查询*/
    @Test
    public void selectOneById() throws Exception {
        MainCategorie mainCategorie = mainCategorieService.selectOneById(9);
        System.out.println(mainCategorie);
    }

    /*测试插入*/
    @Test
    public void insertOne() throws Exception {
        MainCategorie mainCategorie = new MainCategorie();
        mainCategorie.setMaincategorieName("ds");
        int i = mainCategorieService.insertOne(mainCategorie);
    }

}