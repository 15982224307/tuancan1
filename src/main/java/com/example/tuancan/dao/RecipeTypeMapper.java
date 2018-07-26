package com.example.tuancan.dao;

import com.example.tuancan.model.RecipeType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RecipeTypeMapper extends Mapper<RecipeType> {

    /*根据名称查询*/
    @Select("select * from recipetype where RecipeType_name like '%${value}%'")
    public List<RecipeType> selectByName(String name);

    /*根据创建时间逆排序*/
    @Select("select * from recipetype order by RecipeType_createdate DESC")
    public List<RecipeType> selectOrderByCreateDateDESC();

    /*根据创建时间正排序*/
    @Select("select * from recipetype order by RecipeType_createdate ASC")
    public List<RecipeType> selectOrderByCreateDateASC();
}
