package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealContract;

import java.util.List;

public interface GroupMealContractService {

    public GroupMealContract selectOneById(Integer id);

    public List<GroupMealContract> selectAll();

    public List<GroupMealContract> selectByStatus(int status);

    public List<GroupMealContract> selectByExpireDate();

    public int insertOne(GroupMealContract groupMealContract);

    public int updateOne(GroupMealContract groupMealContract);

}
