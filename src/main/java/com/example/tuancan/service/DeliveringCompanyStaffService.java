package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DeliveringCompanyStaff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeliveringCompanyStaffService {

    public DeliveringCompanyStaff selectByIdWithCompany(DeliveringCompanyStaff deliveringCompanyStaff);

    public List<DeliveringCompanyStaff> selectAllByCompanyNo(Integer companyId);

    public int updateOneById(DeliveringCompanyStaff deliveringCompanyStaff);

    public  int insertOne(DeliveringCompanyStaff deliveringCompanyStaff);

   public List<DeliveringCompanyStaff> selecyStaffByLikeName(Integer id,String value);

    /*账号查询*/
   public DeliveringCompanyStaff selectStaffByLoginName(@Param("companyId") Integer id,@Param("name") String name);




}
