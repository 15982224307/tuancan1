package com.example.tuancan.service;

import com.example.tuancan.model.MainCategorie;

import java.util.List;

public interface MainCategorieService {

    /**
     * 查询所有数据*/
    public List<MainCategorie> getAll();

    /**
     * 根据id查询*/
    public MainCategorie selectOneById(Integer id);

    /**
     * 插入数据*/
    public int insertOne(MainCategorie mainCategorie);
}
