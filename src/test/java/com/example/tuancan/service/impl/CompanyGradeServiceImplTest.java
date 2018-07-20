package com.example.tuancan.service.impl;

import com.example.tuancan.model.CompanyGrade;
import com.example.tuancan.service.CompanyGradeService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyGradeServiceImplTest {

    @Autowired
    private CompanyGradeService companyGradeService;

    @Test
    public void deleteById() throws Exception {
        int i = companyGradeService.deleteById(3);
        System.out.println(i);
    }

    @Test
    public void insert() throws Exception {
        CompanyGrade companyGrade = new CompanyGrade();
        companyGrade.setCompanyGradeName("zhuguan");
        companyGrade.setCompanyGradeAuthority("update,insert");
        int insert = companyGradeService.insert(companyGrade);
        System.out.println(insert);
    }

    @Test
    public void selectById() throws Exception {
        CompanyGrade companyGrade = companyGradeService.selectById(1);
        System.out.println(JsonUtil.toJson(companyGrade));
    }

    @Test
    public void selectAll() throws Exception {
        List<CompanyGrade> companyGrades = companyGradeService.selectAll();
        System.out.println(JsonUtil.toJson(companyGrades));
    }

}