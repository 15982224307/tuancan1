package com.example.tuancan.service.impl;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DeliveringCompanyStaff;
import com.example.tuancan.service.DeliveringCompanyStaffService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliveringCompanyStaffServiceImplTest {

    @Autowired
    private DeliveringCompanyStaffService staffService;

    @Test
    public void selectByIdWithCompany() throws Exception {
        DeliveringCompanyStaff deliveringCompanyStaff=new DeliveringCompanyStaff();
        deliveringCompanyStaff.setDCompanyStaffId(1);
        DeliveringCompanyStaff deliveringCompanyStaff1 = staffService.selectByIdWithCompany(deliveringCompanyStaff);
        System.out.println(JsonUtil.toJson(deliveringCompanyStaff1));
    }

    @Test
    public void selectAllByCompanyNo() throws Exception {
    }

    @Test
    public void updateOneById() throws Exception {
        DeliveringCompanyStaff deliveringCompanyStaff = new DeliveringCompanyStaff();

        DeliveringCompany company = new DeliveringCompany();
        company.setDeliveringCompanyNo(2);

        deliveringCompanyStaff.setDCompanyStaffId(1);

        deliveringCompanyStaff.setDeliveringCompany(company);
        deliveringCompanyStaff.setDCompanyStaffMobile("123");
        deliveringCompanyStaff.setDCompanyStaffPosition("dadada");
        deliveringCompanyStaff.setDCompanyStaffAuthority("wu");
        deliveringCompanyStaff.setDCompanyStaffStatus(1);
        deliveringCompanyStaff.setDCompanyStaffDefault(0);
        int i = staffService.updateOneById(deliveringCompanyStaff);
        System.out.println(JsonUtil.toJson(deliveringCompanyStaff));
    }

    @Test
    public void insertOne() throws Exception {
        DeliveringCompanyStaff deliveringCompanyStaff = new DeliveringCompanyStaff();

        DeliveringCompany company = new DeliveringCompany();
        company.setDeliveringCompanyNo(2);

        deliveringCompanyStaff.setDeliveringCompany(company);
        deliveringCompanyStaff.setDCompanyStaffMobile("123");
        deliveringCompanyStaff.setDCompanyStaffPosition("gren");
        deliveringCompanyStaff.setDCompanyStaffAuthority("maimaiami");
        deliveringCompanyStaff.setDCompanyStaffStatus(1);
        deliveringCompanyStaff.setDCompanyStaffDefault(0);


        int i = staffService.insertOne(deliveringCompanyStaff);
        System.out.println(JsonUtil.toJson(deliveringCompanyStaff));
    }

}