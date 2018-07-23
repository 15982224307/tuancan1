package com.example.tuancan.service;

import com.example.tuancan.model.Classification;
import com.example.tuancan.model.MainCategorie;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassificationService {

    /**
     *  根据id 查询单个结果*/
     public Classification selectOneById(Integer id);

    /**
     *  根据name查询单个结果*/
    public Classification selectOneByName(String name);
    /**
     *  s所有结果*/
    public List<Classification> getAll();

}
