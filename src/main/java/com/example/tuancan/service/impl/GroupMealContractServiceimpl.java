package com.example.tuancan.service.impl;

import com.example.tuancan.dao.GroupMealContractMapper;
import com.example.tuancan.model.GroupMealContract;
import com.example.tuancan.service.GroupMealContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupMealContractServiceimpl implements GroupMealContractService {

    @Autowired
    private GroupMealContractMapper groupMealContractMapper;

    @Override
    public List<GroupMealContract> selectOneByUnitId(Integer id) {
        return groupMealContractMapper.selectOneByUnitId(id);
    }

    @Override
    public List<GroupMealContract> selectOneByReipeId(Integer id) {
        return groupMealContractMapper.selectOneByReipeId(id);
    }

    @Override
    public GroupMealContract selectOneById(Integer id) {
        return groupMealContractMapper.selectOneById(id);
    }

    @Override
    public List<GroupMealContract> selectAll() {
        return groupMealContractMapper.selectAll();
    }

    @Override
    public List<GroupMealContract> selectByStatus(int status) {
        return groupMealContractMapper.selectByStatus(status);
    }

    @Override
    public List<GroupMealContract> selectByExpireDate() {
        return groupMealContractMapper.selectByExpireDate();
    }

    @Override
    @Transactional
    public int insertOne(GroupMealContract groupMealContract) {
        return groupMealContractMapper.insertOne(groupMealContract);
    }

    @Override
    @Transactional
    public int updateOne(GroupMealContract groupMealContract) {
        return groupMealContractMapper.updateOne(groupMealContract);
    }
}
