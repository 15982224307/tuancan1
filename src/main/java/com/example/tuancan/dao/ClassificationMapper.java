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
    @Select("select * from classification where classification_name like '%${value}%'")
    @ResultMap(value = "getone")
    public List<Classification> selectByName(String name);

    /*xxx根据主分类id拿*/
    @Select({"select * from classification where maincategorie_id=#{mainid}"})
    public List<Classification> selectByMainId(Integer mainid);

    /*  s所有结果*/
    @Select("select * from classification order by classification_name asc" )
    @ResultMap(value = "getone")
    public List<Classification> getAll();

    @Insert({"insert into classification(maincategorie_id,classification_name) values(#{cascadeType.maincategorieId},#{classificationName})"})
    @Options( useGeneratedKeys = true,keyColumn = "classification_id",keyProperty = "classificationId")
    public int insertOne(Classification classification);

    @Update({"update classification set maincategorie_id=#{cascadeType.maincategorieId},classification_name=#{classificationName} where classification_id=#{classificationId}"})
    public int updateOne(Classification classification);
}
