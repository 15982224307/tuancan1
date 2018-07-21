package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.model.TomorrowMenuMaster;
import com.example.tuancan.model.TomorrowMenudetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TomorrowMenuDetailService {
    /**
     *  根据id 查询单个结果*/
     public TomorrowMenudetail selectOneById(Integer id);

    /**
     * 根据用餐单位查询*/
    public List<TomorrowMenudetail> selectByUnitId(Integer id);

    /**
     * 根据菜单编号查询*/
    public List<TomorrowMenudetail> selectByMenuMasterId(Integer id);

    /**
     * 是否推荐*/
   public List<TomorrowMenudetail> selectByRecommend(int recommend);

    /**
     * 所有数据*/
     public List<TomorrowMenudetail> getAll();

    /**
     * 插入数据*/
    public int insertOne(TomorrowMenudetail tomorrowMenudetail);

    /**
     * 删除数据*/
    public int deleteOne(Integer id);

    /**
     * 更新数据*/
    public int updateOne(TomorrowMenudetail tomorrowMenudetail);
}
