package com.example.tuancan.service.impl;

import com.example.tuancan.model.DeliveringDetail;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.model.Recipe;
import com.example.tuancan.service.DeliveringDetailService;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliveringDetailServiceImplTest {

    @Autowired
    private DeliveringDetailService detailService;

    @Test
    public void selectByDeliveringDetailNo() throws Exception {
    }

    @Test
    public void selectByDeliveringMasterId() throws Exception {
    }

    @Test
    public void selectByrecipeId() throws Exception {
    }

    @Test
    public void insertOne() throws Exception {
        DeliveringDetail detail = new DeliveringDetail();
        String s = KeyUtil.genUniqueKey();
        System.out.println(s);
        detail.setDeliveringDetailNo(s);
        detail.setDeliveringDetailMemo("duojia");
        detail.setDeliveringDetailNumber(5);

        DeliveringMaster master = new DeliveringMaster();
        master.setDeliveringMasterId(2);
        detail.setDeliveringMaster(master);

        Recipe recipe = new Recipe();
        recipe.setRecipeId(3);
        detail.setRecipe(recipe);

        int i = detailService.InsertOne(detail);
        System.out.println(JsonUtil.toJson(detail));
    }

    @Test
    public void updateOne() throws Exception {

        DeliveringDetail detail = new DeliveringDetail();
        detail.setDeliveringDetailNo("1532153966810313469");
        detail.setDeliveringDetailMemo("duojia yigren");
        detail.setDeliveringDetailNumber(6);

        DeliveringMaster master = new DeliveringMaster();
        master.setDeliveringMasterId(2);
        detail.setDeliveringMaster(master);

        Recipe recipe = new Recipe();
        recipe.setRecipeId(1);
        detail.setRecipe(recipe);

        int i = detailService.updateOne(detail);
        System.out.println(JsonUtil.toJson(detail));
    }

}