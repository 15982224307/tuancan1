package com.example.tuancan.dao;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DiningStandard;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DiningStandardMapper extends Mapper<DiningStandard>{

    /**
     * 根据id 查询 数据
     * @param id
     * @return
     */
    @Select({"select * from diningstandard where Standard_id=#{id}"})
    @Results(id = "selectOneWithCompany",value = {
            @Result(column = "DeliveringCompany_no",property = "deliveringCompany",javaType = DeliveringCompany.class,
            one = @One(select = "com.example.tuancan.dao.DeliveringCompanyMapper.selectByPrimaryKey"))
    })
    public DiningStandard selectOneWithCompany(Integer id);

    /**
     * 根据价格和接受的价格波动查询在此价格区间的餐标和所属公司 15.5-2.5====13
     * @param price
     * @return
     */
    @Select({"select * from diningstandard where Standard_price between #{price}-#{bodong} and #{price} order by Standard_price asc"})
    @ResultMap(value = "selectOneWithCompany")
    public List<DiningStandard> selectByPrice(@Param("price") BigDecimal price,@Param("bodong") BigDecimal bodong);

    /**
     * 根据 团餐公司编号 查询其设置的餐标
     * @param companyNo
     * @return
     */
    @Select({"select * from diningstandard where DeliveringCompany_no=#{companyNo} order by Standard_price asc"})
    public List<DiningStandard> selectAllByCompanyNo(Integer companyNo);


    /**
     * 插入一条数据
     * @param diningStandard
     * @return
     */
    @Insert({"insert into diningstandard values(#{standardId},#{deliveringCompany.deliveringCompanyNo},#{standardName},#{standardMeatnumber}," +
            "#{standardVegetablenumber},#{standardPrice},#{standardIsFreeSoup},#{standardIsFreeDessert},#{standardIsFreeFruit},#{standardCreateDate})"})
    @Options(useGeneratedKeys = true,keyProperty = "standardId",keyColumn = "Standard_id")
    public int InsertOne(DiningStandard diningStandard);


    /**
     * 更新数据
     * @param diningStandard
     * @return
     */
    @Update({"update diningstandard set DeliveringCompany_no=#{deliveringCompany.deliveringCompanyNo},Standard_name=#{standardName},Standard_meatnumber=#{standardMeatnumber}," +
            "Standard_Vegetablenumber=#{standardVegetablenumber},Standard_price=#{standardPrice},Standard_IsFreeSoup=#{standardIsFreeSoup}," +
            "Standard_IsFreeDessert=#{standardIsFreeDessert},Standard_isFreeFruit=#{standardIsFreeFruit} where standardId=#{standardId}"})
    @Options(useGeneratedKeys = true,keyProperty = "standardId",keyColumn = "StandardId")
    public  int UpdateOne(DiningStandard diningStandard);


}
