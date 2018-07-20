package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealUnit;

import java.util.Date;
import java.util.List;

public interface GroupMealUnitService {

    /*通过id查询一条数据*/
    public GroupMealUnit selectOneById(Integer id);

    /*通过name查询一条数据*/
    public List<GroupMealUnit> selectOneByName(String name);

    /*根据公司名模糊查询*/
    public List<GroupMealUnit> selectByLikeName(String name);

    /*通过ticket查询一条数据*/
    public GroupMealUnit selectOneByTicket(String name);

    /*查询小于某个时间的数据*/
    public List<GroupMealUnit> selectByReviewLtDate(Date date);

    /*查询大于某个时间的数据*/
    public List<GroupMealUnit> selectByReviewGtDate(Date date);

    /*根据审核日期进行正序*/
    public List<GroupMealUnit> selectByReviewTimeASC();

    /*根据审核日期进行倒序*/
    public List<GroupMealUnit> selectByReviewTimeDESC();

    /*根据状态查找数据*/
    public List<GroupMealUnit> selectByStatus(int status);

    /*查询所有数据*/
    public  List<GroupMealUnit> getAll();

    /*根据删除一条数据*/
    public int deleteOne(Integer id);

    /* 增加一条数据*/
    public int insertOne(GroupMealUnit groupMealUnit);

    /*修改一条数据*/
    public int updateOne(GroupMealUnit groupMealUnit);

}
