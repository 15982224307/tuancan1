package com.example.tuancan.service;

import com.example.tuancan.model.GtodMessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GtodMessageService {

    /**
     * 状态查询*/
    public List<GtodMessage> selectByStatus(Integer status);

    /**
     * 团餐机构消息查询*/
    public List<GtodMessage> selectByUnitId(Integer id);

    /**
     * 根据id查询*/
    public GtodMessage selectById(Integer id);
    /**
     * 查看某个机构的当前时间的未读消息*/
    public List<GtodMessage> selectNoReadByUnitId(Integer id);


    /**
     * 所有数据*/
    public List<GtodMessage> getAll(Integer id);

    /**
     * 特定时间清除消息*/
    public int deleteReaded();

    /**
     * 更新消息*/
   public int updateStatusById(Integer id);

    /**
     * 插入消息*/
    public int insertOne(GtodMessage gtodMessage);
}
