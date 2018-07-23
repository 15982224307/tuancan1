package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface FoodMaterialMapper extends Mapper<FoodMaterial>{

/*  根据id 查询单个结果*/
    @Select("select * from foodmaterial where Foodmaterial_id =#{id}")
    @Results(id="getone",value = {
            @Result(column = "classification_id",property = "classification",javaType = Classification.class,
                    one = @One(select = "com.example.tuancan.dao.ClassificationMapper.selectByPrimaryKey")),
    })
    public FoodMaterial selectOneById(Integer id);

    /*所有数据*/
    @Select("select * from foodmaterial ")
    @ResultMap(value = "getone")
    public List<FoodMaterial> getAll();


    /*  根据小类编号查询结果*/
    @Select("select * from foodmaterial where classification_id =#{id}")
    @ResultMap(value = "getone")
    public List<FoodMaterial> selectByClassId(Integer id);

    /*插入数据*/
    @Insert("insert into foodmaterial values(null,#{classification.classificationId}," +
            "#{oodmaterialName},#{foodmaterialDisc},#{foodmaterialIcon},#{foodmaterialCreatedate})")
    public int insertOne(FoodMaterial foodMaterial);

}
