package com.example.tuancan.service;

import com.example.tuancan.model.DiningStandard;

import java.math.BigDecimal;
import java.util.List;

public interface DiningStandardService {


    public DiningStandard selectOneWithCompany(Integer id);

    public List<DiningStandard> selectByPrice(BigDecimal price, BigDecimal bodong);

    public List<DiningStandard> selectAllByCompanyNo(Integer companyNo);

    public int InsertOne(DiningStandard diningStandard);

    public  int UpdateOne(DiningStandard diningStandard);



}
