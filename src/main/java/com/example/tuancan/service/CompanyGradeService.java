package com.example.tuancan.service;

import com.example.tuancan.model.CompanyGrade;

import java.util.List;

public interface CompanyGradeService {

    public  int deleteById(Integer id);

    public  int insert(CompanyGrade companyGrade);

    public  CompanyGrade selectById(Integer id);

    public List<CompanyGrade> selectAll();
}
