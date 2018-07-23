package com.example.tuancan.service;

import com.example.tuancan.model.TomorrowMenuMaster;

import java.util.List;

public interface TomorrowMenuMasterService {

    /**
     *  根据id 查询单个结果*/
  public TomorrowMenuMaster selectOneById(Integer id);

    /**
     * 根据用餐单位查询*/
     public List<TomorrowMenuMaster> selectByUnitId(Integer id);


     public List<TomorrowMenuMaster> selectByUnitIdAndUseDateAndExpireDate(Integer unitid);

    /**
     * 根据状态查询*/
    public List<TomorrowMenuMaster> selectByStatus(int status);

    /**
     * 查询所有数据*/
    public List<TomorrowMenuMaster> getAll();

    /**
     * 插入数据*/
    public int insertOne(TomorrowMenuMaster tomorrowMenuMaster);

    /**
     * 更新数据*/
    public int updateOne(TomorrowMenuMaster tomorrowMenuMaster);

    /**
     * 删除数据*/
    public int deleteOne(Integer id);

}
