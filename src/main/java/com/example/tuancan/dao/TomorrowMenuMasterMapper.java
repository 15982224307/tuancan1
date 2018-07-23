package com.example.tuancan.dao;

import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.model.TomorrowMenuMaster;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TomorrowMenuMasterMapper extends Mapper<TomorrowMenuMaster> {

    /*  根据id 查询单个结果*/
    @Select("select * from tomorrowmenumaster where TomorrowMenuMaster_id =#{id}")
    @Results(id="getone",value = {
            @Result(column = "GroupMealUnit_id",property = "groupMealUnit",javaType = GroupMealUnit.class,
                    one = @One(select = "com.example.tuancan.dao.GroupMealUnitMapper.selectByPrimaryKey")),
    })
    public TomorrowMenuMaster selectOneById(Integer id);

    /*根据用餐单位查询*/
    @Select("select * from tomorrowmenumaster where GroupMealUnit_id = #{unitid}")
    @ResultMap(value = "getone")
    public List<TomorrowMenuMaster> selectByUnitId(Integer unitid);

    /*根据用餐单位,使用期限，有效期查询唯一菜单主表查询*/
    @Select("select * from tomorrowmenumaster where GroupMealUnit_id = #{unitid} and " +
            "DATE_ADD(CURDATE(),INTERVAL 1 DAY) <= TomorrowMenuMaster_usedate and now() < TomorrowMenuMaster_expiredate")
    public List<TomorrowMenuMaster> selectByUnitIdAndUseDateAndExpireDate(Integer unitid);

    /*根据状态查询*/
    @Select("select * from tomorrowmenumaster where TomorrowMenuMaster_status = #{status}")
    @ResultMap(value = "getone")
    public List<TomorrowMenuMaster> selectByStatus(int status);

    /*查询所有数据*/
    @Select("select * from tomorrowmenumaster")
    @ResultMap(value = "getone")
    public List<TomorrowMenuMaster> getAll();

    /*插入数据*/
    @Insert("insert into tomorrowmenumaster values(null,#{groupMealUnit.groupMealUnitId},#{tomorrowMenuMasterUsedate}," +
            "#{tomorrowMenuMasterExpiredate},#{tomorrowMenuMasterStatus},#{tomorrowMenuMasterMemo},#{tomorrowMenuMasterCreatedate}) ")
    public int insertOne(TomorrowMenuMaster tomorrowMenuMaster);

    /*更新数据*/
    @Update("update tomorrowmenumaster set GroupMealUnit_id = #{groupMealUnit.groupMealUnitId},TomorrowMenuMaster_usedate = #{tomorrowMenuMasterUsedate}," +
            "TomorrowMenuMaster_expiredate = #{tomorrowMenuMasterExpiredate},TomorrowMenuMaster_status = #{tomorrowMenuMasterStatus}," +
            "TomorrowMenuMaster_memo = #{tomorrowMenuMasterMemo},TomorrowMenuMaster_createdate = #{tomorrowMenuMasterCreatedate} " +
            "where TomorrowMenuMaster_id = #{tomorrowMenuMasterId}")
    public int updateOne(TomorrowMenuMaster tomorrowMenuMaster);

    /*删除数据*/
    @Delete("delete from tomorrowmenumaster where TomorrowMenuMaster_id = #{tomorrowMenuMasterId} ")
    public int deleteOne(Integer id);


}
