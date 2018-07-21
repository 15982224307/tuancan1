package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

@Repository
public interface StaffOrderMapper extends Mapper<StaffOrder> {

    /*id查询*/
   @Select("select * from stafforder where StaffOrder_id = #{id}")
   @Results(id="getone",value = {
           @Result(column = "GMStaff_id",property = "gMStaff",javaType = GroupMealStaff.class,
                   one = @One(select = "com.example.tuancan.dao.GroupMealStaffMapper.selectByPrimaryKey")),
           @Result(column = "recipe_id",property = "recipe",javaType = Recipe.class,
                   one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey"))
   })
    public StaffOrder selectOneById(Integer id);

    /*员工编号查询*/
    @Select("select * from stafforder where GMStaff_id =#{id}")
    @ResultMap(value = "getone")
    public List<StaffOrder> selectOneByStaffId(Integer id);

    /*菜谱编号查询*/
    @Select("select * from stafforder where StaffOrder_id =#{id}")
    @ResultMap(value = "getone")
    public List<StaffOrder> selectOneByRecipeId(Integer id);

    /*所有数据*/
    @Select("select * from stafforder ")
    @ResultMap(value = "getone")
    public  List<StaffOrder> getAll();

    /*大于某个时间的所有数据*/
    @Select("select * from stafforder where StaffOrder_date  >= #{date}")
    @ResultMap(value = "getone")
    public  List<StaffOrder> selectGtDateAll(Date date);

    /*插入数据*/
    @Insert("insert into stafforder values(null,#{gMStaff.gMStaffId},#{recipe.recipeId}," +
            "#{staffOrderUsedate},#{staffOrderDate})")
    public int insertOne(StaffOrder staffOrder);

    /*插入数据*/
    @Insert("delete from stafforder where StaffOrder_id =#{id}")
    public int deleteOne(Integer id);

    /*更新数据*/
    @Update("update stafforder set GMStaff_id=#{gMStaff.gMStaffId},recipe_id=#{recipe.recipeId}," +
            "StaffOrder_usedate=#{staffOrderUsedate}," +
            "StaffOrder_date=#{staffOrderDate} where StaffOrder_id = #{staffOrderId}")
    public int updateOne(StaffOrder staffOrder);

}
