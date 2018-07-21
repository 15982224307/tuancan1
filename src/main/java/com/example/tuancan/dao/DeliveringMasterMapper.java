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
    @Select({"select * from deliveringmaster where DeliveringMaster_id=#{deliveringMasterId}"})
    @Results(id = "selectOneById",value = {
            @Result(column = "GroupMealUnit_id",property = "groupMealUnit",javaType = GroupMealUnit.class,
            one = @One(select = "com.example.tuancan.dao.GroupMealUnitMapper.selectByPrimaryKey")),
            @Result(column = "DeliveringCompany_no",property = "deliveringCompany",javaType = DeliveringCompany.class,
            one = @One(select = "com.example.tuancan.dao.DeliveringCompanyMapper.selectByPrimaryKey"))
    })
    public DeliveringMaster selectOneById(DeliveringMaster deliveringMaster);

    /**
     * 通过是否应急查询配送单信息 伴随团餐机构和用餐机构信息
     * @param deliveringMaster
     * @return
     */
    @Select({"select * from deliveringmaster where DeliveringMaster_isEmergency=#{DeliveringMasterIsEmergency}"})
    @ResultMap(value = "selectOneById")
    public List<DeliveringMaster> slectByIsEmergency(DeliveringMaster deliveringMaster);

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
            "DeliveringMaster_delivedate=#{deliveringMasterDelivedate},DeliveringMaster_price=#{deliveringMasterPrice},DeliveringMaster_amount=#{deliveringMasterAmount}," +
            "DeliveringMaster_memo=#{deliveringMasterMemo},DeliveringMaster_status=#{deliveringMasterStatus},DeliveringMaster_isEmergency=#{deliveringMasterIsEmergency}," +
            "DeliveringMaster_creater=#{deliveringMasterCreater},DeliveringMaster_confirmer=#{deliveringMasterConfirmer} where DeliveringMaster_id=#{deliveringMasterId}"})
    @Options(useGeneratedKeys = true,keyProperty = "deliveringMaster_id",keyColumn = "DeliveringMaster_id")
    public int updateOne(DeliveringMaster deliveringMaster);

    /**
     * 插入一条数据
     * @param deliveringMaster
     * @return
     */
    @Insert({"insert into deliveringmaster values(null,#{groupMealUnit.groupMealUnitId},#{deliveringCompany.deliveringCompanyNo}," +
            "#{deliveringMasterDelivedate},#{deliveringMasterPrice},#{deliveringMasterAmount},#{deliveringMasterMemo}," +
            "#{deliveringMasterStatus},#{deliveringMasterIsEmergency},#{deliveringMasterCreatedate},#{deliveringMasterCreater},#{deliveringMasterConfirmer})"
            })
    @Options(useGeneratedKeys = true,keyProperty = "deliveringMasterId",keyColumn = "DeliveringMaster_id")
    public int insertOne(DeliveringMaster deliveringMaster);
}
