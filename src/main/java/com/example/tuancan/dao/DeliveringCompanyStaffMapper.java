package com.example.tuancan.dao;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DeliveringCompanyStaff;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DeliveringCompanyStaffMapper extends Mapper<DeliveringCompanyStaff>{
    /**
     * 根据员工Id查询其信息和所属公司
     * @return
     */
    @Select({"select * from deliveringcompanystaff where DCompanyStaff_id=#{dCompanyStaffId}"})
    @Results(id = "selectByIdWithCompany",value = {
            @Result(column = "DeliveringCompany_no",property = "deliveringCompany",javaType = DeliveringCompany.class,
            one = @One(select = "com.example.tuancan.dao.DeliveringCompanyMapper.selectByPrimaryKey"))
    })
    public DeliveringCompanyStaff selectByIdWithCompany(DeliveringCompanyStaff deliveringCompanyStaff);

    /**
     * 通过公司编号查询其所有员工
     * @param
     * @return
     */
    @Select({"select * from deliveringcompanystaff where DeliveringCompany_no=#{deliveringCompanyNo}"})
    @ResultMap(value = "selectByIdWithCompany")
    public List<DeliveringCompanyStaff> selectAllByCompanyNo(DeliveringCompany deliveringCompany);

    /**
     * 根据id修改员工信息
     * @param deliveringCompanyStaff
     * @return
     */
    @Update({"update deliveringcompanystaff set DeliveringCompany_no=#{deliveringCompany.deliveringCompanyNo},DCompanyStaff_loginname=#{dCompanyStaffLoginname}," +
            "DCompanyStaff_password=#{dCompanyStaffPassword},DCompanyStaff_mobile=#{dCompanyStaffMobile},DCompanyStaff_position=#{dCompanyStaffPosition},DCompanyStaff_default=#{dCompanyStaffDefault}," +
            "DCompanyStaff_authority=#{dCompanyStaffAuthority},DCompanyStaff_status=#{dCompanyStaffStatus} where DCompanyStaff_id=#{dCompanyStaffId}"})
    @Options(useGeneratedKeys = true,keyColumn = "DCompanyStaff_id",keyProperty = "dCompanyStaffId")
    public int updateOneById(DeliveringCompanyStaff deliveringCompanyStaff);

    /**
     * 插入一条员工信息 必须有所属公司编号
     * @param deliveringCompanyStaff
     * @return
     */
    @Insert({"insert into deliveringcompanystaff values(null,#{deliveringCompany.deliveringCompanyNo},#{dCompanyStaffLoginname}," +
            "#{dCompanyStaffPassword},#{dCompanyStaffMobile},#{dCompanyStaffPosition},#{dCompanyStaffDefault}," +
            "#{dCompanyStaffAuthority},#{dCompanyStaffStatus},#{dCompanyStaffCreatedate})"})
    @Options(useGeneratedKeys = true,keyColumn = "DCompanyStaff_id",keyProperty = "dCompanyStaffId")
    public  int insertOne(DeliveringCompanyStaff deliveringCompanyStaff);

}
