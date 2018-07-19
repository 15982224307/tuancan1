package com.example.tuancan.service.impl;

import com.example.tuancan.dao.AnswerMapper;
import com.example.tuancan.model.Answer;
import com.example.tuancan.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public Answer selectOne(Integer id) {

        //return answerMapper.selectOne(id);
        return  null;
    }
}
