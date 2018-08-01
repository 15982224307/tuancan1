package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringCompany;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface DeliveringCompanyService {

    public int insertOne(DeliveringCompany deliveringCompany);

    public int updateOne(DeliveringCompany deliveringCompany);

    public DeliveringCompany selectByIdWithGrade(Integer deliveringCompany);

    public List<DeliveringCompany> selectAllWithGrade();

    public List<DeliveringCompany> selectAllByName(String name);

    public List<DeliveringCompany> selectAllByStatus(Integer status);

    public List<DeliveringCompany> findByExample(Example example);

    public int updateStatusById(Integer id,Integer status);

}
