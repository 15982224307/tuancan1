package com.example.tuancan.service.impl;

import com.example.tuancan.dao.DeliveringCompanyStaffMapper;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DeliveringCompanyStaff;
import com.example.tuancan.service.DeliveringCompanyStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeliveringCompanyStaffServiceImpl implements DeliveringCompanyStaffService{

    @Autowired
    private DeliveringCompanyStaffMapper dCStaffmapper;

    @Override
    public List<DeliveringCompanyStaff> selecyStaffByLikeName(Integer id, String value) {
        return dCStaffmapper.selectStaffByLikeName(id,value);
    }

    @Override
    public DeliveringCompanyStaff selectStaffByLoginName(Integer id, String name) {
        return dCStaffmapper.selectStaffByLoginName(id,name);
    }

    @Override
    public DeliveringCompanyStaff selectByIdWithCompany(DeliveringCompanyStaff deliveringCompanyStaff) {
        return dCStaffmapper.selectByIdWithCompany(deliveringCompanyStaff);
    }

    @Override
    public List<DeliveringCompanyStaff> selectAllByCompanyNo(Integer companyId) {
        return dCStaffmapper.selectAllByCompanyNo(companyId);
    }

    @Override
    @Transactional
    public int updateOneById(DeliveringCompanyStaff deliveringCompanyStaff) {
        return dCStaffmapper.updateOneById(deliveringCompanyStaff);
    }

    @Override
    @Transactional
    public int insertOne(DeliveringCompanyStaff deliveringCompanyStaff) {
        return dCStaffmapper.insertOne(deliveringCompanyStaff);
    }
}
