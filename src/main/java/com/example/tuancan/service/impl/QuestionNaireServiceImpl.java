package com.example.tuancan.service.impl;

import com.example.tuancan.dao.QuestionNaireMapper;
import com.example.tuancan.model.QuestionNaire;
import com.example.tuancan.service.QuestionNaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class QuestionNaireServiceImpl implements QuestionNaireService {

    @Autowired
    private QuestionNaireMapper questionNaireMapper;
    /*查询单个数据*/
    @Override
    public QuestionNaire selectOneById(Integer id) {
        return questionNaireMapper.selectByPrimaryKey(id);
    }

    /*根据描述查询*/
    @Override
    public List<QuestionNaire> selectByDisc(String disc) {
        List <QuestionNaire> questionNaireList = questionNaireMapper.selectByDisc(disc);
        return questionNaireList;
    }

    /*根据类型查询*/
    @Override
    public List<QuestionNaire> selectByType(int type) {
        List <QuestionNaire> questionNaireList = questionNaireMapper.selectByType(type);
        return questionNaireList;
    }

    /*查询所有数据*/
    @Override
    public List<QuestionNaire> selectAll() {
        List <QuestionNaire> questionNaireList = questionNaireMapper.selectAll();
        return questionNaireList;
    }
}
