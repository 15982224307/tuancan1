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
            @Result(column = "GroupMealUnit_id",property = "groupMealUnit",javaType = GroupMealUnit.class,
                    one = @One(select = "com.example.tuancan.dao.GroupMealUnitMapper.selectByPrimaryKey")),
            @Result(column = "TomorrowMenuMaster_id",property = "tomorrowMenuMaster",javaType = TomorrowMenuMaster.class,
                    one = @One(select = "com.example.tuancan.dao.TomorrowMenuMasterMapper.selectByPrimaryKey"))
    })
    public TomorrowMenudetail selectOneById(Integer id);

    /*根据用餐单位查询*/
    @Select("select * from tomorrowmenudetail where GroupMealUnit_id =#{id}")
    @ResultMap(value = "getone")
    public List<TomorrowMenudetail> selectByUnitId(Integer id);

    /*根据菜单编号查询*/
    @Select("select * from tomorrowmenudetail where TomorrowMenuMaster_id =#{id}")
    @ResultMap(value = "getone")
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
    @Insert("insert into  tomorrowmenudetail values(null,#{groupMealUnit.groupMealUnitId},#{tomorrowMenuMaster.tomorrowMenuMasterId}" +
            ",#{tomorrowMenuIsRecommend},#{tomorrowMenuMemo})")
    public int insertOne(TomorrowMenudetail tomorrowMenudetail);

    /*删除数据*/
    @Delete("delete  from tomorrowmenudetail where TomorrowMenu_id =#{id}")
    public int deleteOne(Integer id);

    /*更新数据*/
    @Update("update tomorrowmenudetail set GroupMealUnit_id =#{groupMealUnit.groupMealUnitId},TomorrowMenuMaster_id = #{tomorrowMenuMaster.tomorrowMenuMasterId}," +
            " TomorrowMenu_IsRecommend = #{tomorrowMenuIsRecommend},TomorrowMenu_memo = #{tomorrowMenuMemo} where TomorrowMenu_id =#{tomorrowMenuId}")
    public int updateOne(TomorrowMenudetail tomorrowMenudetail);
}
