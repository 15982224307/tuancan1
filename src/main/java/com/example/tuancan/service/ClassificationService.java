package com.example.tuancan.service;

import com.example.tuancan.model.Classification;

import java.util.List;

public interface ClassificationService {

    /**
     *  根据id 查询单个结果*/
    public Classification selectOneById(Integer id);

    public List<Classification> selectByMainId(Integer mainid);

    /**
     *  根据name查询单个结果*/
    public List<Classification> selectByName(String name);
    /**
     *  s所有结果*/
    public List<Classification> getAll();

    public int insertOne(Classification classification);

    public int updateOne(Classification classification);

}
