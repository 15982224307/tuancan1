package com.example.tuancan.service.impl;

import com.example.tuancan.dao.TomorrowMenuMasterMapper;
import com.example.tuancan.model.TomorrowMenuMaster;
import com.example.tuancan.service.TomorrowMenuMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TomorrowMenuMasterServiceImpl implements TomorrowMenuMasterService {


    @Autowired
    private TomorrowMenuMasterMapper tomorrowMenuMasterMapper;

    /**
     * 根据id 查询单个结果
     *
     * @param id
     */
    @Override
    public TomorrowMenuMaster selectOneById(Integer id) {
        return tomorrowMenuMasterMapper.selectOneById(id);
    }

    /**
     * 根据用餐单位查询
     *
     * @param id
     */
    @Override
    public List<TomorrowMenuMaster> selectByUnitId(Integer id) {
        return tomorrowMenuMasterMapper.selectByUnitId(id);
    }

    /**
     * 根据状态查询
     *
     * @param status
     */
    @Override
    public List<TomorrowMenuMaster> selectByStatus(int status) {
        return tomorrowMenuMasterMapper.selectByStatus(status);
    }

    /**
     * 查询所有数据
     */
    @Override
    public List<TomorrowMenuMaster> getAll() {
        return tomorrowMenuMasterMapper.getAll();
    }

    /**
     * 插入数据
     *
     * @param tomorrowMenuMaster
     */
    @Override
    public int insertOne(TomorrowMenuMaster tomorrowMenuMaster) {
        return tomorrowMenuMasterMapper.insertOne(tomorrowMenuMaster);
    }

    /**
     * 更新数据
     *
     * @param tomorrowMenuMaster
     */
    @Override
    public int updateOne(TomorrowMenuMaster tomorrowMenuMaster) {
        return tomorrowMenuMasterMapper.updateOne(tomorrowMenuMaster);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Override
    public int deleteOne(Integer id) {
        return tomorrowMenuMasterMapper.deleteOne(id);
    }
}
