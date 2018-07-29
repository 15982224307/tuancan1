package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealContract;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GroupMealContractService {

    /*根据单位编号查询数据*/
    public List<GroupMealContract> selectOneByUnitId(Integer id);

    public GroupMealContract selectOneById(Integer id);

    /*根据餐标查询数据*/
    public List<GroupMealContract> selectOneByReipeId(Integer id);

    public List<GroupMealContract> selectAll();

    public List<GroupMealContract> selectByStatus(int status);

    public List<GroupMealContract> selectByExpireDate();

    public int insertOne(GroupMealContract groupMealContract);

    public int updateOne(GroupMealContract groupMealContract);

}
