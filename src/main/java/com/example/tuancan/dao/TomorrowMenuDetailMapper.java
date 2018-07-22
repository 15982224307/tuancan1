package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TomorrowMenuDetailMapper extends Mapper<TomorrowMenudetail>{

    /*  根据id 查询单个结果*/
    @Select("select * from tomorrowmenudetail where TomorrowMenu_id =#{id}")
    @Results(id="getone",value = {
            @Result(column = "recipe_id",property = "recipe",javaType = Recipe.class,
                    one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey")),
            @Result(column = "TomorrowMenuMaster_id",property = "tomorrowMenuMaster",javaType = TomorrowMenuMaster.class,
                    one = @One(select = "com.example.tuancan.dao.TomorrowMenuMasterMapper.selectByPrimaryKey"))
    })
    public TomorrowMenudetail selectOneById(Integer id);

    /*根据食谱id查询*/
    @Select("select * from tomorrowmenudetail where recipe_id =#{id}")
    @ResultMap(value = "getone")
    public List<TomorrowMenudetail> selectByRecipeId(Integer id);

    /*根据菜单编号查询 已经不需要明日菜单主表id*/
    @Select("select * from tomorrowmenudetail where TomorrowMenuMaster_id =#{id}")
    @Results(id="selectByMenuMasterId",value = {
            @Result(column = "recipe_id",property = "recipe",javaType = Recipe.class,
                    one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey")),
    })
    public List<TomorrowMenudetail> selectByMenuMasterId(Integer id);

    /*是否推荐*/
    @Select("select * from tomorrowmenudetail where TomorrowMenu_IsRecommend =#{recommend}")
    @ResultMap(value = "getone")
    public List<TomorrowMenudetail> selectByRecommend(int recommend);

    /*所有数据*/
    @Select("select * from tomorrowmenudetail")
    @ResultMap(value = "getone")
    public List<TomorrowMenudetail> getAll();

    /*插入数据*/
    @Insert("insert into  tomorrowmenudetail values(null,#{recipe.recipeId},#{tomorrowMenuMaster.tomorrowMenuMasterId}" +
            ",#{tomorrowMenuIsRecommend},#{tomorrowMenuMemo})")
    public int insertOne(TomorrowMenudetail tomorrowMenudetail);

    /*删除数据*/
    @Delete("delete  from tomorrowmenudetail where TomorrowMenu_id =#{id}")
    public int deleteOne(Integer id);

    /*更新数据*/
    @Update("update tomorrowmenudetail set GroupMealUnit_id =#{recipe.recipeId},TomorrowMenuMaster_id = #{tomorrowMenuMaster.tomorrowMenuMasterId}," +
            " TomorrowMenu_IsRecommend = #{tomorrowMenuIsRecommend},TomorrowMenu_memo = #{tomorrowMenuMemo} where TomorrowMenu_id =#{tomorrowMenuId}")
    public int updateOne(TomorrowMenudetail tomorrowMenudetail);
}
