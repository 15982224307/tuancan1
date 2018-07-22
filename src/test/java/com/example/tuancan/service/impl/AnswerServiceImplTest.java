package com.example.tuancan.service.impl;

import com.example.tuancan.dao.AnswerMapper;
import com.example.tuancan.model.Answer;
import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.QuestionNaire;
import com.example.tuancan.service.AnswerService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerServiceImplTest {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerMapper answerMapper;
    @Test
    public void selectOne() throws Exception {
        Answer answer = answerService.selectOne(3);
        System.out.println(answer);
    }

    @Test
    public void selectAnswerByQues_idOrderByAnswer_date() throws Exception {
        QuestionNaire questionNaire = new QuestionNaire();
        questionNaire.setQuestionnaireId(1);
        List<Answer> answers = answerService.selectAnswerByQues_idOrderByAnswer_date(questionNaire);
        System.out.println(JsonUtil.toJson(answers));
    }

    @Test
    public void selectAnswerByGMStaff_idOrderByAnswer_date() throws Exception {
        GroupMealStaff groupMealStaff = new GroupMealStaff();
        groupMealStaff.setGMStaffId(1);
        List<Answer> answers = answerService.selectAnswerByGMStaff_idOrderByAnswer_date(groupMealStaff);
        System.out.println(JsonUtil.toJson(answers));
    }

    @Test
    public void insert() throws Exception {
        GroupMealStaff groupMealStaff = new GroupMealStaff();
        groupMealStaff.setGMStaffId(1);
        QuestionNaire questionNaire = new QuestionNaire();
        questionNaire.setQuestionnaireId(1);
        Answer answer = new Answer();
        answer.setAnswerText("ggg");
        //answer.setAnswerDate(new Date(new java.util.Date().getTime()));
        answer.setGMStaff(groupMealStaff);
        answer.setQuestionnaire(questionNaire);
        int insert = answerService.insertAnswer(answer);

        System.out.println(insert);
    }

    @Test
    public void updateOne()throws Exception{
        Answer answer = answerService.selectOne(13);
        answer.setAnswerText("dsda");
        int i = answerService.updateOne(answer);
        System.out.println(i);

    }

    @Test
    public void deleteOne() throws Exception {
        int delete = answerService.deleteOne(13);
        System.out.println(delete);
    }
}