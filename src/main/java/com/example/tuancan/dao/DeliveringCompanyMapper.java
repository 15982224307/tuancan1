package com.example.tuancan.dao;

import com.example.tuancan.model.CompanyGrade;
import com.example.tuancan.model.DeliveringCompany;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DeliveringCompanyMapper extends Mapper<DeliveringCompany>{

    /**
     * 插入一条数据 并且把等级外键插入
     * @param deliveringCompany
     * @return
     */
    @Insert({"insert into deliveringcompany(CompanyGrade_id,DeliveringCompany_name,DeliveringCompany_contact,DeliveringCompany_Mobile,DeliveringCompany_license," +
            "DeliveringCompany_address,DeliveringCompany_status,DeliveringCompany_bank,DeliveringCompany_account,DeliveringCompany_disc,DeliveringCompany_tel) values(#{companyGrade.companyGradeId},#{deliveringCompanyName}," +
            "#{deliveringCompanyContact},#{deliveringCompanyMobile},#{deliveringCompanyLicense}," +
            "#{deliveringCompanyAddress},#{deliveringCompanyStatus},#{deliveringCompanyBank}," +
            "#{deliveringCompanyAccount},#{deliveringCompanyDisc},#{deliveringCompanyTel})"})
    @Options(useGeneratedKeys = true,keyProperty = "deliveringCompanyNo",keyColumn = "DeliveringCompany_no")
    public int insertOne(DeliveringCompany deliveringCompany);

    /**
     * 更新团餐机构的数据 或者等级
     * @param deliveringCompany
     * @return
     */
    @Update({"update deliveringcompany set CompanyGrade_id=#{companyGrade.companyGradeId},DeliveringCompany_name=#{deliveringCompanyName}," +
            "DeliveringCompany_contact=#{deliveringCompanyContact},DeliveringCompany_Mobile=#{deliveringCompanyMobile},DeliveringCompany_license=#{deliveringCompanyLicense}," +
            "DeliveringCompany_address=#{deliveringCompanyAddress},DeliveringCompany_status=#{deliveringCompanyStatus},DeliveringCompany_bank=#{deliveringCompanyBank}," +
            "DeliveringCompany_account=#{deliveringCompanyAccount},DeliveringCompany_disc=#{deliveringCompanyDisc},DeliveringCompany_tel=#{deliveringCompanyTel}," +
            "DeliveringCompany_reviewDate=#{deliveringCompanyReviewDate} where DeliveringCompany_no=#{deliveringCompanyNo}"})
    public int updateOne(DeliveringCompany deliveringCompany);

    /**
     * 通过 名称团餐机构的数据
     * @return
     */
    @Select({"select * from deliveringcompany where DeliveringCompany_name like '%${value}%' order by DeliveringCompany_name "})
    public List<DeliveringCompany> selectAllByName(String name);

    /**
     * 通过 状态团餐机构的数据
     * @return
     */
    @Select({"select * from deliveringcompany where  DeliveringCompany_status=#{status} order by DeliveringCompany_name "})
    public List<DeliveringCompany> selectAllByStatus(Integer status);

    /**
     * 查询一个团餐机构的数据 并且伴随其等级
     * @return
     */
    @Select({"select * from deliveringcompany where DeliveringCompany_no=#{deliveringCompanyNo}"})
    @Results(id = "selectByIdWithGrade",value = {
            @Result(column = "CompanyGrade_id",property = "companyGrade",javaType = CompanyGrade.class,
                    one = @One(select = "com.example.tuancan.dao.CompanyGradeMapper.selectByPrimaryKey"))
    })
    public DeliveringCompany selectByIdWithGrade(Integer deliveringCompany);

    /**
     * cha询所有团餐机构的数据 并且伴随其等级
     * @return
     */
    @Select({"select * from deliveringcompany  order by DeliveringCompany_name "})
    @ResultMap(value = "selectByIdWithGrade")
    public List<DeliveringCompany> selectAllWithGrade();

    @Update({"update deliveringcompany set DeliveringCompany_status=#{status} where DeliveringCompany_no=#{id}"})
    public int updateStatusById(@Param("id")Integer id,@Param("status")Integer status);

}
