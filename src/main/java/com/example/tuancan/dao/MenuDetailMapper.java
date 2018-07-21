package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MenuDetailMapper extends Mapper<MenuDetail>{

    @Select("select * from menudetail where MenuDetail_no =#{no}")
    @Results(id="getone",value = {
            @Result(column = "GroupMealMenumaster_id",property = "groupMealMenumasterId",javaType = GroupMealMenumaster.class,
                    one = @One(select = "com.example.tuancan.dao.GroupMealMenuMasterMapper.selectByPrimaryKey")),
            @Result(column = "recipe_id",property = "recipeId",javaType = Recipe.class,
                    one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey"))

    })
    public MenuDetail selectByNo(Integer no);

}
