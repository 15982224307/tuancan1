package com.example.tuancan.service;

import com.example.tuancan.model.Manager;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface ManagerService {

    /*删除一条数据*/
    public int deleteOne(Integer id);

    /*增加一条数据*/
    public int insertOne(Manager manager);

    /*修改数据*/
    public int updateOne(Manager manager);

    /*根据id查询*/
    public Manager selectOneByid(Integer id);

    /*根据name查询字段*/
    public Manager selectOneByName(String name);

    /*根据logingName查询*/
    public Manager selectOneByLoginName(String loginName);

    /*根据状态查询*/
    public List<Manager> selectOneByStatus(int status);

    /*得到所有数据*/
    public List<Manager> selectAll();

}
