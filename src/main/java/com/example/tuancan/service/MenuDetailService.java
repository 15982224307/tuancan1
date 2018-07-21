package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealMenumaster;
import com.example.tuancan.model.MenuDetail;
import com.example.tuancan.model.Recipe;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuDetailService {

    /**
     * 菜单编号查询*/
  public List<MenuDetail> selectByMasterNo(Integer no);


    /**
     * 食谱编号查询*/
    public List<MenuDetail> selectByRecipeNo(Integer no);

    /*食谱编号和菜单编号查询*/
   public MenuDetail selectByRecipeNoAndMasterNo(Integer m_no,Integer r_no);


    /**
     * 菜单序号号查询*/
    public List<MenuDetail> selectByDetailId(Integer no);

    /**
     * 插入数据*/
     public int insertOne(MenuDetail menuDetail);

    /**
     * 更新数据*/
     public int updateOne(MenuDetail menuDetail);

    /**
     * 删除数据*/
   public int deleteOne(MenuDetail menuDetail);



}
