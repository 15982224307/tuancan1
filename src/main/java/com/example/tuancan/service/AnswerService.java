package com.example.tuancan.service;

import com.example.tuancan.model.Answer;
import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.QuestionNaire;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface AnswerService {
    public Answer selectOne(Integer id);
    public List<Answer> selectAnswerByQues_idOrderByAnswer_date(QuestionNaire questionNaire);
    public List<Answer> selectAnswerByGMStaff_idOrderByAnswer_date(GroupMealStaff groupMealStaff);
    public int deleteOne(Integer id);
    public int insertAnswer(Answer answer);
    public int updateOne(Answer answer);
}
