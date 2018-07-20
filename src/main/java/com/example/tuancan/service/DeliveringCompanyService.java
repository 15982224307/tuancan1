package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringCompany;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface DeliveringCompanyService {

    public int insertOne(DeliveringCompany deliveringCompany);

    public int updateOne(DeliveringCompany deliveringCompany);

    public DeliveringCompany selectByIdWithGrade(DeliveringCompany deliveringCompany);

    public List<DeliveringCompany> selectAllWithGrade();

    public List<DeliveringCompany> findByExample(Example example);

}
