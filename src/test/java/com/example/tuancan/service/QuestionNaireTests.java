package com.example.tuancan.service;

import com.example.tuancan.model.QuestionNaire;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionNaireTests {

    @Autowired
    private QuestionNaireService questionNaireService;

    /*测试查询一条数据*/
    @Test
    public void selectOne(){
        QuestionNaire questionNaire = questionNaireService.selectOneById(1);
        System.out.println(JsonUtil.toJson(questionNaire));
    }

    /*测试按描述查询*/
    @Test
    public void selectByDisc() throws Exception {

        List<QuestionNaire> questionNaireList = questionNaireService.selectByDisc("ab");
        System.out.println(JsonUtil.toJson(questionNaireList));
    }

    /*测试按类型查询*/
    @Test
    public void selectByType() throws Exception {
        List<QuestionNaire> questionNaireList = questionNaireService.selectByType(1);
        System.out.println(JsonUtil.toJson(questionNaireList));
    }

    /*测试查找所有数据*/
    @Test
    public void selectAll() throws Exception {
        List<QuestionNaire> questionNaireList = questionNaireService.selectAll();
        System.out.println(JsonUtil.toJson(questionNaireList));
    }

    /*测试插入数据*/
    @Test
    public void insertOne() throws Exception {
        QuestionNaire questionNaire = new QuestionNaire();
        questionNaire.setQuestionnaireDisc("efg");
        questionNaire.setQuestionnaireType(2);
        questionNaire.setQuestionnaireChoiceA("e");
        questionNaire.setQuestionnaireChoiceB("r");
        questionNaire.setQuestionnaireChoiceC("t");
        questionNaire.setQuestionnaireChoiceD("y");
        System.out.println(questionNaire);
        int i = questionNaireService.insertOne(questionNaire);
        System.out.println(i);

    }
    /*测试删除数据*/
    @Test
    public void deleteOne(){
        int i = questionNaireService.deleteOne(3);
        System.out.println(i);
    }

    /*测试修改数据*/
    @Test
    public void updateOne(){
        QuestionNaire questionNaire = questionNaireService.selectOneById(4);
        questionNaire.setQuestionnaireChoiceA("a");
        questionNaire.setQuestionnaireChoiceB("b");
        questionNaire.setQuestionnaireChoiceC("c");
        questionNaire.setQuestionnaireChoiceD("d");
        int i = questionNaireService.updateOne(questionNaire);
        System.out.println(i);
    }
}