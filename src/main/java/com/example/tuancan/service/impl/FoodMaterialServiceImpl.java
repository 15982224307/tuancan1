package com.example.tuancan.service.impl;

import com.example.tuancan.dao.FoodMaterialMapper;
import com.example.tuancan.model.FoodMaterial;
import com.example.tuancan.service.FoodMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodMaterialServiceImpl implements FoodMaterialService {

    @Autowired
    private FoodMaterialMapper foodMaterialMapper;

    /**
     * 根据id 查询单个结果
     *
     * @param id
     */
    @Override
    public FoodMaterial selectOneById(Integer id) {
        return foodMaterialMapper.selectOneById(id);
    }

    /**
     * 根据小类编号查询结果
     *
     * @param id
     */
    @Override
    public List<FoodMaterial> selectByClassId(Integer id) {
        return foodMaterialMapper.selectByClassId(id);
    }

    @Override
    public int updateOne(FoodMaterial foodMaterial) {
        return foodMaterialMapper.updateOne(foodMaterial);
    }

    @Override
    public int updatePic(Integer fmid, String pathurl) {
        return foodMaterialMapper.updatePic(fmid,pathurl);
    }

    @Override
    public List<FoodMaterial> selectByName(String name) {
        return foodMaterialMapper.selectByName(name);
    }

    /**
     * 所有数据
     */
    @Override
    public List<FoodMaterial> getAll() {
        return foodMaterialMapper.getAll();
    }

    /**
     * 插入数据
     *
     * @param foodMaterial
     */
    @Override
    public int insertOne(FoodMaterial foodMaterial) {
        return foodMaterialMapper.insertOne(foodMaterial);
    }
}
