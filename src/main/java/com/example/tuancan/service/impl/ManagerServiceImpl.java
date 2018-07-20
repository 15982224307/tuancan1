package com.example.tuancan.service.impl;

import com.example.tuancan.dao.ManagerMapper;
import com.example.tuancan.model.Manager;
import com.example.tuancan.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    /*根据id删除数据*/
    @Override
    public int deleteOne(Integer id) {

       return managerMapper.deleteByPrimaryKey(id);
    }

    /*插入一条数据*/
    @Override
    public int insertOne(Manager manager) {
        return managerMapper.insert(manager);
    }

    /*修改数据*/
    @Override
    public int updateOne(Manager manager) {
        return managerMapper.updateByPrimaryKeySelective(manager);
    }

    /*所有数据*/
    @Override
    public List<Manager> selectAll() {
        return managerMapper.selectAll();
    }

    /*根据id查询*/
    @Override
    public Manager selectOneByid(Integer id) {
        return managerMapper.selectByPrimaryKey(id);
    }

    /*根据name查询*/
    @Override
    public Manager selectOneByName(String name) {

        return managerMapper.selectOneByName(name);

    }

    /*根据登录名查询*/
    @Override
    public Manager selectOneByLoginName(String loginName) {
        return managerMapper.selectOneByLoginName(loginName);
    }

    /*根据状态查询*/
    @Override
    public Manager selectOneByStatus(int status) {
        return managerMapper.selectOneByStatus(status);
    }
}
