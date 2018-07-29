package com.example.tuancan.dao;

import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.model.GroupMealContract;
import com.example.tuancan.model.GroupMealUnit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface GroupMealContractMapper  extends Mapper<GroupMealContract>{

    /**
     * 根据id 查询合同
     * @param id
     * @return
     */
    @Select({"select * from groupmealcontract where GMContract_id=#{id}"})
    @Results(id="selectOne",value = {
            @Result(column = "Standard_id",property = "standard",javaType = DiningStandard.class,
                    one = @One(select = "com.example.tuancan.dao.DiningStandardMapper.selectOneWithCompany")),
            @Result(column = "GroupMealUnit_id",property = "groupMealUnit",javaType = GroupMealUnit.class,
                    one = @One(select = "com.example.tuancan.dao.GroupMealUnitMapper.selectByPrimaryKey"))
    })
    public GroupMealContract selectOneById(Integer id);


    /*根据单位编号查询数据*/
    @Select("select * from groupmealcontract where GroupMealUnit_id=#{id}")
    @ResultMap(value = "selectOne")
    public List<GroupMealContract> selectOneByUnitId(Integer id);


    /*根据餐标查询数据*/
    @Select("select * from groupmealcontract where Standard_id=#{id}")
    @ResultMap(value = "selectOne")
    public List<GroupMealContract> selectOneByReipeId(Integer id);

    /**
     * 查询合同所有数据
     * @return
     */
    @Select({"select * from groupmealcontract"})
    public List<GroupMealContract> selectAll();

    /**
     * 根据状态查询所有合同
     * @param status
     * @return
     */
    @Select({"select * from groupmealcontract where GMlContract_status=#{status}"})
    public List<GroupMealContract> selectByStatus(int status);

    /**
     * 查询在有效期内的合同
     * @return
     */
    @Select({"select * from groupmealcontract HAVING NOW() < GMlContract_expirydate"})
    public List<GroupMealContract> selectByExpireDate();

    /**
     * 新建合同数据
     * @param groupMealContract
     * @return
     */
    @Insert({"insert into groupmealcontract values(null,#{standard.standardId},#{groupMealUnit.groupMealUnitId},#{gMlContractName}," +
            "#{gMlContractDisc},#{gMlContractExpirydate},#{gMContractMeatnumber},#{gMlContractVegetablenumber}," +
            "#{gMlContractStatus},#{gMContractSigndate},#{gMlContractGroupA},#{gMContractGroupB},#{gMContractCreateDate})"})
    @Options(useGeneratedKeys = true,keyColumn = "GMContract_id",keyProperty = "gMContractId")
    public int insertOne(GroupMealContract groupMealContract);


    /**
     * 更新合同数据
     * @param groupMealContract
     * @return
     */
    @Update({"update groupmealcontract set Standard_id=#{standard.standardId},GroupMealUnit_id=#{groupMealUnit.groupMealUnitId},GMlContract_name=#{gMlContractName}," +
            "GMlContract_disc=#{gMlContractDisc},GMlContract_expirydate=#{gMlContractExpirydate},GMContract_meatnumber=#{gMContractMeatnumber},GMlContract_vegetablenumber=#{gMlContractVegetablenumber}," +
            "GMlContract_status=#{gMlContractStatus} where GMContract_id=#{gMContractId}"})
    @Options(useGeneratedKeys = true,keyColumn = "GMContract_id",keyProperty = "gMContractId")
    public int updateOne(GroupMealContract groupMealContract);

}
