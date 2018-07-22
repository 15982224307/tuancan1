package com.example.tuancan.dao;

import com.example.tuancan.model.Manager;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ManagerMapper extends Mapper<Manager>{


    /*根据name查询字段*/
    @Select("select * from manager where manager_name =#{name} ")
    public Manager selectOneByName(String name);

    /*根据logingName查询*/
    @Select("select * from manager where manager_loginname =#{loginName} ")
    public Manager selectOneByLoginName(String loginName);

    /*根据状态查询*/
    @Select("select * from manager where manager_status =#{status} ")
    public List<Manager> selectOneByStatus(int status);
}
