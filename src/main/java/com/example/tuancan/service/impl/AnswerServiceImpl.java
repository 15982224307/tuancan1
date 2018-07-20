package com.example.tuancan.service.impl;

import com.example.tuancan.dao.AnswerMapper;
import com.example.tuancan.model.Answer;
import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.QuestionNaire;
import com.example.tuancan.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerMapper answerMapper;
    /*  根据id 查询单个结果*/
    @Override
    public Answer selectOne(Integer id) {

        //return answerMapper.selectOne(id);
        return  answerMapper.getone(id);
    }
    /**
     *根据问卷编号查询所有问答情况 并时间排序
     * @return
     */
    @Override
    public List<Answer> selectAnswerByQues_idOrderByAnswer_date(QuestionNaire questionNaire) {
        return answerMapper.selectAnswerByQues_idOrderByAnswer_date(questionNaire);
    }
    /**
     *根据该员工编号查询其所属问答情况 并时间排序
     * @return
     */
    @Override
    public List<Answer> selectAnswerByGMStaff_idOrderByAnswer_date(GroupMealStaff groupMealStaff) {
        return answerMapper.selectAnswerByGMStaff_idOrderByAnswer_date(groupMealStaff);
    }

    /**
     * 通过id删除一条数据
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int deleteOne(Integer id) {
        return answerMapper.deleteByPrimaryKey(id);
    }
    /**
     * 插入一条问答数据
     * @param answer
     * @return
     */
    @Override
    @Transactional
    public int insertAnswer(Answer answer) {

        int insert = answerMapper.insert(answer);
        //开启事务后插入有错会回滚
        /*if (!"cd".equals("")){
            throw  new RuntimeException("shujuhuigun");
        }*/
        return insert;
    }
}
