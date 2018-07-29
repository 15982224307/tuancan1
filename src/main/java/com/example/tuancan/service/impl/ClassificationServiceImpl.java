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

    @Override
    public List<Classification> selectByMainId(Integer mainid) {
        return classificationMapper.selectByMainId(mainid);
    }

    /**
     * s所有结果
     */
    @Override
    public List<Classification> getAll() {
        return classificationMapper.getAll();
    }

    @Override
    public int insertOne(Classification classification) {
        return classificationMapper.insertOne(classification);
    }

    @Override
    public int updateOne(Classification classification) {
        return classificationMapper.updateOne(classification);
    }

    /**
     * 根据name查询单个结果
     *
     * @param name
     */
    @Override
    public List<Classification> selectByName(String name) {
        return classificationMapper.selectByName(name);
    }
}
