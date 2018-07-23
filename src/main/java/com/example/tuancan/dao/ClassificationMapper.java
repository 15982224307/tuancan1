package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ClassificationMapper extends Mapper<Classification>{

    /*  根据id 查询单个结果*/
    @Select("select * from classification where classification_id = #{id}")
    @Results(id="getone",value = {
            @Result(column = "maincategorie_id",property = "cascadeType",javaType = MainCategorie.class,
                    one = @One(select = "com.example.tuancan.dao.MainCategorieMapper.selectByPrimaryKey")),
              })
    public Classification selectOneById(Integer id);

    /*  根据name查询单个结果*/
    @Select("select * from classification where classification_name = #{name}")
    @ResultMap(value = "getone")
    public Classification selectOneByName(String name);


    /*  s所有结果*/
    @Select("select * from classification " )
    @ResultMap(value = "getone")
    public List<Classification> getAll();



}
