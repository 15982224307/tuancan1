package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MenuDetailMapper extends Mapper<MenuDetail>{

    /*菜单编号查询*/
    @Select("select * from menudetail where GroupMealMenumaster_id = #{no}")
    @Results(id="getone",value = {
            @Result(column = "GroupMealMenumaster_id",property = "groupMealMenumaster",javaType = GroupMealMenumaster.class,
                    one = @One(select = "com.example.tuancan.dao.GroupMealMenumasterMapper.selectByPrimaryKey")),
            @Result(column = "recipe_id",property = "recipe",javaType = Recipe.class,
                    one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey"))

    })
    public List<MenuDetail> selectByMasterNo(Integer no);


    /*食谱编号查询*/
    @Select("select * from menudetail where recipe_id =#{no}")
    @ResultMap(value = "getone")
    public List<MenuDetail> selectByRecipeNo(Integer no);

    /*食谱编号和菜单编号查询*/
    @Select("select * from menudetail where GroupMealMenumaster_id = #{m_no} and recipe_id = #{r_no}")
    @ResultMap(value = "getone")
    public MenuDetail selectByRecipeNoAndMasterNo(@Param("m_no") Integer m_no,@Param("r_no") Integer r_no);


    /*菜单序号号查询*/
    @Select("select * from menudetail where MenuDetail_no =#{no}")
    @ResultMap(value = "getone")
    public List<MenuDetail> selectByDetailId(Integer no);

    /*插入数据*/
    @Insert("insert into menudetail values(#{groupMealMenumaster.groupMealMenumasterId},#{recipe.recipeId}," +
            "#{menuDetailNo},#{menuDetailMome})")
    public int insertOne(MenuDetail menuDetail);

    /*更新数据*/
    @Update("update menudetail set GroupMealMenumaster_id = #{groupMealMenumaster.groupMealMenumasterId},recipe_id = #{recipe.recipeId}," +
            "MenuDetail_mome = #{menuDetailMome} where MenuDetail_no = #{menuDetailNo}")
    public int updateOne(MenuDetail menuDetail);

    /*删除数据*/
    @Delete("delete from menudetail where GroupMealMenumaster_id = #{groupMealMenumaster.groupMealMenumasterId} and recipe_id = #{recipe.recipeId} ")
    public int deleteOne(MenuDetail menuDetail);


}
