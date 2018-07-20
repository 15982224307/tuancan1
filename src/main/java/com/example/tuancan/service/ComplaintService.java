package com.example.tuancan.service;

import com.example.tuancan.model.Complaint;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface ComplaintService {

    public List<Complaint> selectAllOrderByComplaintDate(Example example);

    public List<Complaint> selectAllByManagerId(Integer managerId);

    public List<Complaint> selectAllBByComplaintSettleOrderBySettleDate(String complaintSettle);

    public Complaint selectOneByIdWithManager(Integer complaintId);

    public Complaint selectById(Integer id);

    public int insertOne(Complaint complaint);

    public int updateOne(Complaint complaint);


}
