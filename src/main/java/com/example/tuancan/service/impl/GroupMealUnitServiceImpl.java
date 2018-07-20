package com.example.tuancan.service.impl;

import com.example.tuancan.dao.GroupMealUnitMapper;
import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.service.GroupMealUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class GroupMealUnitServiceImpl implements GroupMealUnitService {

    @Autowired
    private GroupMealUnitMapper groupMealUnitMapper;

    /*通过id查询*/
    @Override
    public GroupMealUnit selectOneById(Integer id) {

        return groupMealUnitMapper.selectByPrimaryKey(id);
    }

    /*通过公司名查询*/
    @Override
    public List<GroupMealUnit> selectOneByName(String name) {

        return groupMealUnitMapper.selectByName(name);
    }

    /*通过ticket查询*/
    @Override
    public GroupMealUnit selectOneByTicket(String ticket) {

        return groupMealUnitMapper.selectByTicket(ticket);
    }

    /*查询小于某个时间的数据*/
    @Override
    public List<GroupMealUnit> selectByReviewLtDate(Date date) {
        return groupMealUnitMapper.selectByReviewLtDate(date);
    }

    /*查询大于某个时间的数据*/
    @Override
    public List<GroupMealUnit> selectByReviewGtDate(Date date) {
        return groupMealUnitMapper.selectByReviewGtDate(date);
    }

    /*正序查询*/
    @Override
    public List<GroupMealUnit> selectByReviewTimeASC() {
        return groupMealUnitMapper.selectByReviewTimeASC();
    }

    /*倒序查询*/
    @Override
    public List<GroupMealUnit> selectByReviewTimeDESC() {
        return groupMealUnitMapper.selectByReviewTimeDESC();
    }

    /*查询所有数据*/
    @Override
    public List<GroupMealUnit> getAll() {
        return groupMealUnitMapper.selectAll();
    }

    /*删除一条数据*/
    @Override
    public int deleteOne(Integer id) {

        return groupMealUnitMapper.deleteByPrimaryKey(id);
    }

    /*根据状态查找数据*/
    @Override
    public List<GroupMealUnit> selectByStatus(int status) {

        return groupMealUnitMapper.selectByStatus(status);
    }

    /*插入一条数据*/
    @Override
    public int insertOne(GroupMealUnit groupMealUnit) {
        return groupMealUnitMapper.insert(groupMealUnit);
    }

    /*更新数据*/
    @Override
    public int updateOne(GroupMealUnit groupMealUnit) {
        return groupMealUnitMapper.updateByPrimaryKeySelective(groupMealUnit);
    }

    /*工具公司名模糊查询*/
    @Override
    public List<GroupMealUnit> selectByLikeName(String name) {
        return groupMealUnitMapper.selectByLikeName(name);
    }
}
