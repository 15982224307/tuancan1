package com.example.tuancan.service.impl;

import com.example.tuancan.dao.ComplaintMapper;
import com.example.tuancan.model.Complaint;
import com.example.tuancan.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    private ComplaintMapper complaintMapper;

    /**
     * 通过组合条件Example查询 所有想均为类的属性
     * 如：Example example=new Example(Complaint.class);
     example.orderBy("complaintDate").desc();
     Example.Criteria criteria = example.createCriteria();
     criteria.andEqualTo("complaintSettle",0);
     List<Complaint> complaints = complaintService.selectAllOrderByComplaintDate(example);
     * @param example
     */
    @Override
    public List<Complaint> selectAllOrderByComplaintDate(Example example) {
       //Example example=new Example(Complaint.class);
        return complaintMapper.selectByExample(example);
    }

    /**
     * 通过id查询 但其外键属性Manager类为空
     * @param id
     * @return
     */
    @Override
    public Complaint selectById(Integer id) {
        return complaintMapper.selectByPrimaryKey(id);
    }
    /**
     * 插入一条投诉数据
     * @param complaint
     * @return
     */
    @Override
    @Transactional
    public int insertOne(Complaint complaint) {
        return complaintMapper.insertOne(complaint);
    }

    /**
     * 修改投诉的处理结果和处理日期，以及所属平台管理员的id
     * @param complaint
     * @return
     */
    @Override
    @Transactional
    public int updateOne(Complaint complaint) {
        return complaintMapper.updateOne(complaint);
    }
}
