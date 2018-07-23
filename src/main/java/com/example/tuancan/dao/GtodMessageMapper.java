package com.example.tuancan.dao;

import com.example.tuancan.model.GtodMessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface GtodMessageMapper extends Mapper<GtodMessage>{

    /*状态查询*/
    @Select("select * from gtodmessage where gtodmessage_status = #{status} ")
    public List<GtodMessage> selectByStatus(Integer status);

    /*团餐机构消息查询*/
    @Select("select * from gtodmessage where gtodmessage_receiver = #{id} ")
    public List<GtodMessage> selectByUnitId(Integer id);

    /*查看某个机构的当前时间的未读消息*/
    @Select("select * from gtodmessage where gtodmessage_status = 0 and gtodmessage_receiver = #{id}")
    public List<GtodMessage> selectNoReadByUnitId(Integer id);


    /*特定时间清除消息*/
    @Delete("delete from gtodmessage where gtodmessage_status = 1")
    public int deleteReaded();

    /*更新消息*/
    @Update("update gtodmessage set gtodmessage_status = 1 where gtodmessage_id = #{id}")
    public int updateStatusById(Integer id);

    /*插入消息*/
    @Insert("insert into gtodmessage values(null,#{gtodmessageStatus},#{gtodmessageContent}," +
            "#{gtodmessageSender},#{gtodmessageReceiver},#{gtodmessagereatedate})")
    public int insertOne(GtodMessage gtodMessage);
}
