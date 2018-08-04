package com.example.tuancan.service.impl;

import com.example.tuancan.dao.StaffOrderMapper;
import com.example.tuancan.model.StaffOrder;
import com.example.tuancan.service.StaffOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StaffOrderServiceImpl implements StaffOrderService {

    @Autowired
    private StaffOrderMapper staffOrderMapper;

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public StaffOrder selectOneById(Integer id) {
        return staffOrderMapper.selectOneById(id);
    }

    /**
     * 员工编号查询
     *
     * @param id
     */
    @Override
    public List<StaffOrder> selectOneByStaffId(Integer id) {
        return staffOrderMapper.selectOneByStaffId(id);
    }

    /**
     * 员工编号和日期查询
     *
     * @param id
     * @param date
     */
    @Override
    public List<StaffOrder> selectOneByStaffIdAnduseDate(Integer id, Date date) {
        return staffOrderMapper.selectOneByStaffIdAnduseDate(id,date);
    }

    /**
     * 菜谱编号查询
     *
     * @param id
     */
    @Override
    public List<StaffOrder> selectOneByRecipeId(Integer id) {
        return staffOrderMapper.selectOneByRecipeId(id);
    }

    /**
     * 所有数据
     */
    @Override
    public List<StaffOrder> getAll() {
        return staffOrderMapper.getAll();
    }

    /**
     * 小于某个时间的所有数据
     *
     * @param date
     */
    @Override
    public List<StaffOrder> selectGtDateAll(Date date) {
        return staffOrderMapper.selectGtDateAll(date);
    }

    /**
     * 插入数据
     *
     * @param staffOrder
     */
    @Override
    public int insertOne(StaffOrder staffOrder) {
        return staffOrderMapper.insertOne(staffOrder);
    }


    /**
     * 插入数据
     *
     * @param id
     */
    @Override
    public int deleteOne(Integer id) {
        return staffOrderMapper.deleteOne(id);
    }

    /**
     * 更新数据
     *
     * @param staffOrder
     */
    @Override
    public int updateOne(StaffOrder staffOrder) {
        return staffOrderMapper.updateOne(staffOrder);
    }
}
