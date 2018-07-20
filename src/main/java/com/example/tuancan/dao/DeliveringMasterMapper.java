package com.example.tuancan.dao;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.model.GroupMealUnit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DeliveringMasterMapper extends Mapper<DeliveringMaster>{

    /**
     * 通过id 查询配送单信息 伴随团餐机构和用餐机构信息
     * @return
     */
    @Select({"select * from deliveringmaster where DeliveringMaster_id=#{deliveringMaster_id}"})
    @Results(id = "selectOneById",value = {
            @Result(column = "DeliveringMaster_id",property = "deliveringMaster_id",javaType = int.class),
            @Result(column = "GroupMealUnit_id",property = "groupMealUnit",javaType = GroupMealUnit.class,
            one = @One(select = "com.example.tuancan.dao.GroupMealUnitMapper.selectByPrimaryKey")),
            @Result(column = "DeliveringCompany_no",property = "deliveringCompany",javaType = DeliveringCompany.class,
            one = @One(select = "com.example.tuancan.dao.DeliveringCompanyMapper.selectByPrimaryKey"))
    })
    public DeliveringMaster selectOneById(DeliveringMaster deliveringMaster);

    /**
     * 查询送单信息数据集 伴随团餐机构和用餐机构信息
     * @return
     */
    @Select({"select * from deliveringmaster order by DeliveringMaster_delivedate"})
    @ResultMap(value = "selectOneById")
    public List<DeliveringMaster> selectAllWithDeliverComAndMealUnit();

    /**
     * 更新数据
     * @param deliveringMaster
     * @return
     */
    @Update({"update deliveringmaster set GroupMealUnit_id=#{groupMealUnit.groupMealUnitId},DeliveringCompany_no=#{deliveringCompany.deliveringCompanyNo}," +
            "DeliveringMaster_delivedate=#{deliveringMaster_delivedate},DeliveringMaster_price=#{deliveringMaster_price},DeliveringMaster_amount=#{deliveringMaster_amount}," +
            "DeliveringMaster_memo=#{deliveringMaster_memo},DeliveringMaster_status=#{deliveringMaster_status},DeliveringMaster_isEmergency=#{deliveringMaster_isEmergency}," +
            "DeliveringMaster_creater=#{deliveringMaster_creater},DeliveringMaster_confirmer=#{deliveringMaster_confirmer} where DeliveringMaster_id=#{deliveringMaster_id}"})
    @Options(useGeneratedKeys = true,keyProperty = "deliveringMaster_id",keyColumn = "DeliveringMaster_id")
    public int updateOne(DeliveringMaster deliveringMaster);

    /**
     * 插入一条数据
     * @param deliveringMaster
     * @return
     */
    @Insert({"insert into deliveringmaster values(null,#{groupMealUnit.groupMealUnitId},#{deliveringCompany.deliveringCompanyNo}," +
            "#{deliveringMaster_delivedate},#{deliveringMaster_price},#{deliveringMaster_amount},#{deliveringMaster_memo}," +
            "#{deliveringMaster_status},#{deliveringMaster_isEmergency},#{deliveringMaster_createdate},#{deliveringMaster_creater},#{deliveringMaster_confirmer})"
            })
    @Options(useGeneratedKeys = true,keyProperty = "deliveringMaster_id",keyColumn = "DeliveringMaster_id")
    public int insertOne(DeliveringMaster deliveringMaster);
}
