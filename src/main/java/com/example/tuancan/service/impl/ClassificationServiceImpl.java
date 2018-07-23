package com.example.tuancan.service.impl;

import com.example.tuancan.dao.ClassificationMapper;
import com.example.tuancan.model.Classification;
import com.example.tuancan.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    private ClassificationMapper classificationMapper;

    /**
     * 根据id 查询单个结果
     *
     * @param id
     */
    @Override
    public Classification selectOneById(Integer id) {
        return classificationMapper.selectOneById(id);
    }

    /**
     * s所有结果
     */
    @Override
    public List<Classification> getAll() {
        return classificationMapper.getAll();
    }

    /**
     * 根据name查询单个结果
     *
     * @param name
     */
    @Override
    public Classification selectOneByName(String name) {
        return classificationMapper.selectOneByName(name);
    }
}
