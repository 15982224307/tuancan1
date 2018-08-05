package com.example.tuancan.dao;

import com.example.tuancan.model.GroupMealMenumaster;
import com.example.tuancan.model.GroupMealUnit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface GroupMealMenumasterMapper extends Mapper<GroupMealMenumaster> {

    /**
     * 根据菜单名称模糊查询
     * @param name
     * @return
     */
    @Select({"select * from groupmealmenumaster where GroupMealMenumaster_name like '%${value}%'"})
    @ResultMap(value = "selectOneById")
    public List<GroupMealMenumaster> selectByName(String name);

    /**
     * 根据用餐单位ID查询
     */
    @Select({"select * from groupmealmenumaster where GroupMealUnit_id=#{groupMealUnitId}"})
    @ResultMap(value = "selectOneById")
    public  GroupMealMenumaster selectByUnitId(Integer groupMealUnitId);

    /**
     *  查询所有
     */
    @Select({"select * from groupmealmenumaster order by GroupMealMenumaster_name asc"})
    @ResultMap(value = "selectOneById")
    public List<GroupMealMenumaster> selectAllWithUnit();

    /**
     * 根据id 查询
     */
    @Select({"select * from groupmealmenumaster where GroupMealMenumaster_id=#{id}"})
    @Results(id = "selectOneById",value = {
            @Result(column = "GroupMealUnit_id",property = "groupMealUnit",javaType = GroupMealUnit.class,
            one = @One(select = "com.example.tuancan.dao.GroupMealUnitMapper.selectByPrimaryKey"))
    })
    public GroupMealMenumaster selectOneById(Integer id);


    /**
     * 更新数据
     * @param groupMealMenumaster
     * @return
     */
    @Update({"update groupmealmenumaster set GroupMealUnit_id=#{groupMealUnit.groupMealUnitId},GroupMealMenumaster_name=#{groupMealMenumasterName} " +
            "where GroupMealMenumaster_id=#{groupMealMenumasterId}"})
    @Options(useGeneratedKeys = true,keyColumn = "GroupMealMenumaster_id",keyProperty = "groupMealMenumasterId")
    public  int UpdateOne(GroupMealMenumaster groupMealMenumaster);

    /**
     * 插入数据
     * @param groupMealMenumaster
     * @return
     */
    @Insert({"insert into groupmealmenumaster(GroupMealUnit_id,GroupMealMenumaster_name) values(#{groupMealUnit.groupMealUnitId},#{groupMealMenumasterName})"})
    @Options(useGeneratedKeys = true,keyColumn = "GroupMealMenumaster_id",keyProperty = "groupMealMenumasterId")
    public  int InsertOne(GroupMealMenumaster groupMealMenumaster);


}
