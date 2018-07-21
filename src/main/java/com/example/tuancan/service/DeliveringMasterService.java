package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringMaster;

import java.util.List;

public interface DeliveringMasterService {

    public DeliveringMaster selectOneById(DeliveringMaster deliveringMaster);

    public List<DeliveringMaster> selectAllWithDeliverComAndMealUnit();

    public List<DeliveringMaster> slectByIsEmergency(DeliveringMaster deliveringMaster);

    public int updateOne(DeliveringMaster deliveringMaster);

    public int insertOne(DeliveringMaster deliveringMaster);

}
