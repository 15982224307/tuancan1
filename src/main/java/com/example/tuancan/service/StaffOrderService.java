package com.example.tuancan.service;

import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.Recipe;
import com.example.tuancan.model.StaffOrder;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface StaffOrderService {


    /**
     * 查询
     * @param id
     * @return
     */
    public StaffOrder selectOneById(Integer id);

    /**
     * 员工编号查询
     **/
   public List<StaffOrder> selectOneByStaffId(Integer id);

    /**
     * 菜谱编号查询
     */
   public List<StaffOrder> selectOneByRecipeId(Integer id);

    /**
     * 所有数据
     */
    public  List<StaffOrder> getAll();

    /**
     * 小于某个时间的所有数据*/
   public  List<StaffOrder> selectGtDateAll(Date date);

    /**
     * 插入数据*/
    public int insertOne(StaffOrder staffOrder);

    /**
     * 插入数据*/
    public int deleteOne(Integer id);

    /**
     * 更新数据*/
    public int updateOne(StaffOrder staffOrder);
}
