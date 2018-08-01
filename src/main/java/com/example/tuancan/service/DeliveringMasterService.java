package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringMaster;

import java.util.List;

public interface DeliveringMasterService {

    public DeliveringMaster selectOneById(Integer deliveringMasterId);

    public List<DeliveringMaster> selectAllWithDeliverComAndMealUnit();

    /*通过用餐公司id查询*/
    public List<DeliveringMaster> selectByUnitId(Integer unitId);

    /*通过团餐id*/
    public List<DeliveringMaster> selectBydcNo(Integer dcNo);

    public List<DeliveringMaster> slectByIsEmergency(DeliveringMaster deliveringMaster);

    public int updateOne(DeliveringMaster deliveringMaster);

    public int insertOne(DeliveringMaster deliveringMaster);

}
