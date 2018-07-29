package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealMenumaster;

import java.util.List;

public interface GroupMealMenumasterService {

    public GroupMealMenumaster selectOneById(Integer id);

    public List<GroupMealMenumaster> selectByName(String name);

    public List<GroupMealMenumaster> selectAllWithUnit();

    public  GroupMealMenumaster selectByUnitId(Integer groupMealUnitId);

    public  int UpdateOne(GroupMealMenumaster groupMealMenumaster);

    public  int InsertOne(GroupMealMenumaster groupMealMenumaster);

}
