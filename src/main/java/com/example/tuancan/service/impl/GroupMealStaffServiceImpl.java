package com.example.tuancan.service.impl;

import com.example.tuancan.dao.GroupMealStaffMapper;
import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.service.GroupMealStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMealStaffServiceImpl implements GroupMealStaffService {

    @Autowired
    private GroupMealStaffMapper groupMealStaffMapper;

    /*  根据id 查询单个结果*/
    @Override
    public GroupMealStaff selectOneById(Integer id) {
        return groupMealStaffMapper.selectOneById(id);
    }
    /*  查询所有结果*/
    @Override
    public List<GroupMealStaff> selectAll() {
        return groupMealStaffMapper.gettAll();
    }
    /*查询公司对应的所有员工*/
    @Override
    public List<GroupMealStaff> selectByUnitId(Integer id) {
        return groupMealStaffMapper.selectByUnitId(id);
    }
    /*根据name查询*/
    @Override
    public GroupMealStaff selectByName(String name) {
        return groupMealStaffMapper.selectByName(name);
    }
    /*根据状态查询*/
    @Override
    public List<GroupMealStaff> selectByStatus(int status) {
        return groupMealStaffMapper.selectByStatus(status);
    }
    /*查询是默认账号*/
    @Override
    public List<GroupMealStaff> selectByIsDefault(int isdefault) {
        return groupMealStaffMapper.selectByIsDefault(isdefault);
    }
    /*根据登陆账号查询*/
    @Override
    public GroupMealStaff selectByLoginName(String loginName) {
        return groupMealStaffMapper.selectByLoginName(loginName);
    }
    /*根据openid查询*/
    @Override
    public GroupMealStaff selectByOpenid(String openid) {
        return groupMealStaffMapper.selectByOpenid(openid);
    }
    /*根据ticket查询*/
    @Override
    public GroupMealStaff selectByTicket(String ticket) {
        return groupMealStaffMapper.selectByTicket(ticket);
    }
    /*创建时间正序*/
    @Override
    public List<GroupMealStaff> selcetOrderByCreateTimeASC() {
        return groupMealStaffMapper.selcetOrderByCreateTimeASC();
    }
    /*创建时间逆序*/
    @Override
    public List<GroupMealStaff> selcetOrderByCreateTimeDESC() {
        return groupMealStaffMapper.selcetOrderByCreateTimeDESC();
    }
    /*插入数据*/
    @Override
    public int insertOne(GroupMealStaff groupMealStaff) {
        return groupMealStaffMapper.insertOne(groupMealStaff);
    }
    /*删除数据*/
    @Override
    public int deleteOne(Integer id) {
        return  groupMealStaffMapper.deleteOneById(id);

    }
    /*更新数据*/
    @Override
    public int updateOne(GroupMealStaff groupMealStaff) {
        return groupMealStaffMapper.updateOne(groupMealStaff);
    }
}
