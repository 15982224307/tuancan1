package com.example.tuancan.service.impl;

import com.example.tuancan.model.CompanyGrade;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.service.DeliveringCompanyService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliveringCompanyServiceImplTest {

    @Autowired
    private DeliveringCompanyService service;
    @Test
    public void insertOne() throws Exception {
        DeliveringCompany deliveringCompany = new DeliveringCompany();

        CompanyGrade companyGrade = new CompanyGrade();
        companyGrade.setCompanyGradeId(1);

        deliveringCompany.setCompanyGrade(companyGrade);
        deliveringCompany.setDeliveringCompanyNo(127980);
        deliveringCompany.setDeliveringCompanyName("xihua");
        deliveringCompany.setDeliveringCompanyContact("33333");
        deliveringCompany.setDeliveringCompanyMobile("13072865896");
        deliveringCompany.setDeliveringCompanyLicense("111");
        deliveringCompany.setDeliveringCompanyStatus(1);
        deliveringCompany.setDeliveringCompanyAddress("xihua416");
        deliveringCompany.setDeliveringCompanyAddress("1");
        deliveringCompany.setDeliveringCompanyBank("zh_bank");
        deliveringCompany.setDeliveringCompanyAccount("5222222");
        deliveringCompany.setDeliveringCompanyDisc("greate");
        deliveringCompany.setDeliveringCompanyTel("012-4515");
        //deliveringCompany.setDeliveringCompanyReviewDate();

        service.insertOne(deliveringCompany);
        System.out.println(deliveringCompany);
    }

    @Test
    public void updateOne() throws Exception {
        DeliveringCompany deliveringCompany = new DeliveringCompany();

        CompanyGrade companyGrade = new CompanyGrade();
        companyGrade.setCompanyGradeId(1);

        deliveringCompany.setDeliveringCompanyNo(2);
        deliveringCompany.setCompanyGrade(companyGrade);
        deliveringCompany.setDeliveringCompanyName("fff");
        deliveringCompany.setDeliveringCompanyContact("33333");
        deliveringCompany.setDeliveringCompanyMobile("13072865896");
        deliveringCompany.setDeliveringCompanyLicense("111");
        deliveringCompany.setDeliveringCompanyStatus(1);
        deliveringCompany.setDeliveringCompanyAddress("xihua416");
        deliveringCompany.setDeliveringCompanyAddress("1");
        deliveringCompany.setDeliveringCompanyBank("zh_bank");
        deliveringCompany.setDeliveringCompanyAccount("5222222");
        deliveringCompany.setDeliveringCompanyDisc("greate");
        deliveringCompany.setDeliveringCompanyTel("012-4515");
        deliveringCompany.setDeliveringCompanyReviewDate(new Date());

        service.updateOne(deliveringCompany);
    }

    @Test
    public void selectByIdWithGrade() throws Exception {
        DeliveringCompany deliveringCompany = new DeliveringCompany();
        deliveringCompany.setDeliveringCompanyNo(2);

        DeliveringCompany deliveringCompany1 = service.selectByIdWithGrade(deliveringCompany.getDeliveringCompanyNo());
        System.out.println(JsonUtil.toJson(deliveringCompany1));
    }

    @Test
    public void selectAllWithGrade() throws Exception {

        List<DeliveringCompany> deliveringCompanies = service.selectAllWithGrade();
        System.out.println(JsonUtil.toJson(deliveringCompanies));
    }
}