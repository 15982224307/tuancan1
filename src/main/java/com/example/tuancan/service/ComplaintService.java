package com.example.tuancan.service;

import com.example.tuancan.model.Complaint;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface ComplaintService {

    public List<Complaint> selectAllOrderByComplaintDate(Example example);

    public Complaint selectById(Integer id);

    public int insertOne(Complaint complaint);

    public int updateOne(Complaint complaint);


}
