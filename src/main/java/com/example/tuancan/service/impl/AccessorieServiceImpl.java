package com.example.tuancan.service.impl;

import com.example.tuancan.dao.AccessorieMapper;
import com.example.tuancan.model.Accessorie;
import com.example.tuancan.service.AccessorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessorieServiceImpl implements AccessorieService {

    @Autowired
    private AccessorieMapper accessorieMapper;

    /**
     * 根据编号查询单个结果
     *
     * @param id
     */
    @Override
    public Accessorie selectOneByNo(Integer id) {
        return accessorieMapper.selectOneByNo(id);
    }

    /**
     * 根据食材编号查询结果
     *
     * @param id
     */
    @Override
    public List<Accessorie> selectOneByFoodId(Integer id) {
        return accessorieMapper.selectOneByFoodId(id);
    }

    /**
     * 根据食谱编号查询结果
     *
     * @param id
     */
    @Override
    public List<Accessorie> selectOneByRecipeId(Integer id) {
        return accessorieMapper.selectOneByRecipeId(id);
    }

    /**
     * 插入数据
     *
     * @param accessorie
     */
    @Override
    public int insertOne(Accessorie accessorie) {
        return accessorieMapper.insertOne(accessorie);
    }

    /**
     * 所有结果
     */
    @Override
    public List<Accessorie> getAll() {
        return accessorieMapper.getAll();
    }

    /**
     * 插入数据
     *
     * @param accessorie
     */
    @Override
    public int updateOne(Accessorie accessorie) {
        return accessorieMapper.updateOne(accessorie);
    }
}
