package com.example.tuancan.service.impl;

import com.example.tuancan.dao.RecipeTypeMapper;
import com.example.tuancan.model.RecipeType;
import com.example.tuancan.service.RecipeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeTyeImpl implements RecipeTypeService {

    @Autowired
    private RecipeTypeMapper recipeTypeMapper;

    /*插入数据*/
    @Override
    public int insertOne(RecipeType recipeType) {
        return recipeTypeMapper.insert(recipeType);
    }

    /*更新数据*/
    @Override
    public int updateOne(RecipeType recipeType) {
        return recipeTypeMapper.updateByPrimaryKey(recipeType);
    }

    /*根据id删除*/
    @Override
    public int deleteOne(Integer id) {
        return recipeTypeMapper.deleteByPrimaryKey(id);
    }

    /*根据id查询*/
    @Override
    public RecipeType selectOneById(Integer id) {
        return recipeTypeMapper.selectByPrimaryKey(id);
    }

    /*根据name查询*/
    @Override
    public RecipeType selectOneByName(String name) {
        return recipeTypeMapper.selectOneByName(name);
    }

    /*得到所有数据*/
    @Override
    public List<RecipeType> selectAll() {
        return recipeTypeMapper.selectAll();
    }

    /*逆序排序*/
    @Override
    public List<RecipeType> selectOrderByCreateDateASC() {
        return recipeTypeMapper.selectOrderByCreateDateASC();
    }

    /*正序排序*/
    @Override
    public List<RecipeType> selectOrderByCreateDateDESC() {
        return recipeTypeMapper.selectOrderByCreateDateASC();
    }

}
