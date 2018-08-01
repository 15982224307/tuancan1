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

    /**
     * 通过id 查询配送单信息 伴随团餐机构和用餐机构信息
     * @return
     */
    @Override
    public DeliveringMaster selectOneById(Integer deliveringMasterId) {
        return deliveringMasterMapper.selectOneById(deliveringMasterId);
    }

    /**
     * 查询送单信息数据集 伴随团餐机构和用餐机构信息
     * @return
     */
    @Override
    public List<DeliveringMaster> selectAllWithDeliverComAndMealUnit() {
        return deliveringMasterMapper.selectAllWithDeliverComAndMealUnit();
    }

    @Override
    public List<DeliveringMaster> selectByUnitId(Integer unitId) {
        return deliveringMasterMapper.selectByUnitId(unitId);
    }

    @Override
    public List<DeliveringMaster> selectBydcNo(Integer dcNo) {
        return deliveringMasterMapper.selectBydcNo(dcNo);
    }

    /**
     * 通过是否应急查询配送单信息 伴随团餐机构和用餐机构信息
     * @param deliveringMaster
     * @return
     */
    @Override
    public List<DeliveringMaster> slectByIsEmergency(DeliveringMaster deliveringMaster) {
        return deliveringMasterMapper.slectByIsEmergency(deliveringMaster);
    }

    /**
     * 更新数据
     * @param deliveringMaster
     * @return
     */
    @Override
    public int updateOne(DeliveringMaster deliveringMaster) {
        return deliveringMasterMapper.updateOne(deliveringMaster);
    }

    /**
     * 插入一条数据
     * @param deliveringMaster
     * @return
     */
    @Override
    public int insertOne(DeliveringMaster deliveringMaster) {
        return deliveringMasterMapper.insertOne(deliveringMaster);
    }
}
