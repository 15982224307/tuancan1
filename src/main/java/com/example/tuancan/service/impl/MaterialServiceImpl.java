package com.example.tuancan.service.impl;

import com.example.tuancan.dao.MaterialMapper;
import com.example.tuancan.model.Material;
import com.example.tuancan.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 根据id 查询单个结果
     *
     * @param id
     */
    @Override
    public Material selectOneById(Integer id) {
        return materialMapper.selectOneById(id);
    }

    /**
     * 根据食材编号查询结果
     *
     * @param id
     */
    @Override
    public List<Material> selectOneByFoodId(Integer id) {
        return materialMapper.selectOneByFoodId(id);
    }

    /**
     * 所有结果
     */
    @Override
    public List<Material> getAll() {
        return materialMapper.getAll();
    }

    /**
     * 根据食谱编号查询结果
     *
     * @param id
     */
    @Override
    public List<Material> selectOneByRecipeId(Integer id) {
        return materialMapper.selectOneByRecipeId(id);
    }

    /**
     * 插入数据
     *
     * @param material
     */
    @Override
    public int insertOne(Material material) {
        return materialMapper.insertOne(material);
    }

    /**
     * 插入数据
     *
     * @param material
     */
    @Override
    public int updateOne(Material material) {
        return materialMapper.updateOne(material);
    }
}
