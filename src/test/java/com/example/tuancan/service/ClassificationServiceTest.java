package com.example.tuancan.service;

import com.example.tuancan.model.Classification;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassificationServiceTest {

    @Autowired
    private ClassificationService classificationService;

    /*测试所有数据*/
    @Test
    public void getAll() throws Exception {
        List<Classification> all = classificationService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }

    /*测试id查询*/
    @Test
    public void selectOneById() throws Exception {
        Classification classification = classificationService.selectOneById(17);
        System.out.println(JsonUtil.toJson(classification));
    }

    /*测试name查询*/
    @Test
    public void selectOneByName() throws Exception {
        List<Classification> classification = classificationService.selectByName("鸡");
        System.out.println(JsonUtil.toJson(classification));
    }

}