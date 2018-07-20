package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DeliveringCompanyStaff;

import java.util.List;

public interface DeliveringCompanyStaffService {

    public DeliveringCompanyStaff selectByIdWithCompany(DeliveringCompanyStaff deliveringCompanyStaff);

    public List<DeliveringCompanyStaff> selectAllByCompanyNo(DeliveringCompany deliveringCompany);

    public int updateOneById(DeliveringCompanyStaff deliveringCompanyStaff);

    public  int insertOne(DeliveringCompanyStaff deliveringCompanyStaff);

}
