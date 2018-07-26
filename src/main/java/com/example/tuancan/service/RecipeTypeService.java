package com.example.tuancan.service;

import com.example.tuancan.model.RecipeType;

import java.util.List;

public interface RecipeTypeService {

    /*新增数据*/
    public int insertOne(RecipeType recipeType);

    /*修改数据*/
    public int updateOne(RecipeType recipeType);

    /*删除数据*/
    public int deleteOne(Integer id);


    /*通过id查询数据*/
    public RecipeType selectOneById(Integer id);

    /*通过name查询数据*/
    public List<RecipeType> selectByName(String name);

    /*得到所有数据*/
    public List<RecipeType> selectAll();

    /*创建时间正序*/
    public List<RecipeType> selectOrderByCreateDateASC();

    /*创建时间倒序*/
    public List<RecipeType> selectOrderByCreateDateDESC();
}
