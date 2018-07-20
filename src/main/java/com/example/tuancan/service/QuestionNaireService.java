package com.example.tuancan.service;

import com.example.tuancan.model.QuestionNaire;

import java.util.List;

public interface QuestionNaireService {

    /*查询单个数据*/
    public QuestionNaire selectOneById(Integer id);

    /* 根据描述查询*/
    public List<QuestionNaire> selectByDisc(String disc);

    /* 根据问卷类型查询*/
    public  List<QuestionNaire> selectByType(int type);

    /*查询所有数据*/
    public List<QuestionNaire> selectAll();

    /*增加一条数据*/
    public int insertOne(QuestionNaire questionNaire);

    /*删除一条数据*/
    public int deleteOne(Integer id);

    /*修改一条数据*/
    public int updateOne(QuestionNaire questionNaire);

}
