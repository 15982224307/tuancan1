package com.example.tuancan.dao;

import com.example.tuancan.model.GroupMealUnit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

@Repository
public interface GroupMealUnitMapper extends Mapper<GroupMealUnit>{

    /*根据公司名查询*/
    @Select("select * from groupmealunit where GroupMealUnit_name =#{name}")
    public List<GroupMealUnit> selectByName(String name);

    /*根据ticket查询*/
    @Select("select * from groupmealunit where GroupMealUnit_ticker_id =#{ticket}")
    public GroupMealUnit selectByTicket(String ticket);


    /*根据公司名模糊查询*/
    @Select("select * from groupmealunit where GroupMealUnit_name like '%${value}%' ")
    public List<GroupMealUnit> selectByLikeName(String name);

    /*根据审核日期进行正序*/
    @Select("SELECT * FROM groupmealunit ORDER BY GroupMealUnit_reviewDate ASC")
    public List<GroupMealUnit> selectByReviewTimeASC();

    /*根据审核日期进行倒序*/
    @Select("SELECT * FROM groupmealunit ORDER BY GroupMealUnit_reviewDate DESC")
    public List<GroupMealUnit> selectByReviewTimeDESC();


    /*根据状态查找数据*/
    @Select("SELECT * from groupmealunit where GroupMealUnit_status = #{status} ")
    public List<GroupMealUnit> selectByStatus(int status);

    /*t通过审核日期查询数据*/
    @Select("SELECT * FROM groupmealunit where GroupMealUnit_reviewDate <#{date}")
    public List<GroupMealUnit> selectByReviewLtDate(Date date);

    /*t通过审核日期查询数据*/
    @Select("SELECT * FROM groupmealunit where GroupMealUnit_reviewDate >#{date}")
    public List<GroupMealUnit> selectByReviewGtDate(Date date);

    /*xx根据id更新状态*/
    @Update({"update groupmealunit set GroupMealUnit_status=#{status} where GroupMealUnit_id=#{id}"})
    public int updateStatusById(@Param("id")Integer id,@Param("status") Integer status);
}
