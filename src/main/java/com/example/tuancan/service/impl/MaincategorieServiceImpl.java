package com.example.tuancan.service.impl;

import com.example.tuancan.dao.MainCategorieMapper;
import com.example.tuancan.model.MainCategorie;
import com.example.tuancan.service.MainCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaincategorieServiceImpl implements MainCategorieService{

    @Autowired
    private MainCategorieMapper mainCategorieMapper;

    /**
     * 查询所有数据
     */
    @Override
    public List<MainCategorie> getAll() {
        return mainCategorieMapper.selectAll();
    }

    /**
     * 插入数据
     *
     * @param mainCategorie
     */
    @Override
    public int insertOne(MainCategorie mainCategorie) {
        return mainCategorieMapper.insert(mainCategorie);
    }

    /**
     * 根据id查询
     *
     * @param id
     */
    @Override
    public MainCategorie selectOneById(Integer id) {
        return mainCategorieMapper.selectByPrimaryKey(id);
    }
}
