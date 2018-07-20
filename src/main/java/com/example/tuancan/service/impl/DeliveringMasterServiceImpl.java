package com.example.tuancan.service.impl;

import com.example.tuancan.dao.DeliveringMasterMapper;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.service.DeliveringMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveringMasterServiceImpl implements DeliveringMasterService {

    @Autowired
    private DeliveringMasterMapper deliveringMasterMapper;

    @Override
    public DeliveringMaster selectOneById(DeliveringMaster deliveringMaster) {
        return deliveringMasterMapper.selectOneById(deliveringMaster);
    }

    @Override
    public List<DeliveringMaster> selectAllWithDeliverComAndMealUnit() {
        return deliveringMasterMapper.selectAllWithDeliverComAndMealUnit();
    }

    @Override
    public int updateOne(DeliveringMaster deliveringMaster) {
        return deliveringMasterMapper.updateOne(deliveringMaster);
    }

    @Override
    public int insertOne(DeliveringMaster deliveringMaster) {
        return deliveringMasterMapper.insertOne(deliveringMaster);
    }
}
