package com.example.tuancan.dao;

import com.example.tuancan.model.MainCategorie;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MainCategorieMapper extends Mapper<MainCategorie> {

    /*通过名称查询*/
    @Select({"select * from maincategorie where maincategorie_name like '%${value}%'"})
    public List<MainCategorie> selectByName(String name);
}
