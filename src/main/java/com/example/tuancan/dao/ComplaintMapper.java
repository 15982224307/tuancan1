package com.example.tuancan.dao;

import com.example.tuancan.model.Complaint;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ComplaintMapper extends Mapper<Complaint>{

   /* @Select("")
    @Results(id = "",value = {
            @Result(column = "",property = "")
    })
    public List<Complaint> selectByManagerId();*/

    /**
     * 插入一条投诉数据
     * @param complaint
     * @return
     */
    @Insert({"insert into complaint(manager_id,Complainter,Complaint_content,Complaint_settle) " +
            "values(#{manager.managerId},#{complainter},#{complaintContent},#{complaintSettle})"})
    @Options(useGeneratedKeys = true,keyColumn = "Complaint_id",keyProperty = "complaintId")
    public int insertOne(Complaint complaint);

    /**
     * 修改投诉的处理结果和处理日期，以及平台管理员的id
     * @param complaint
     * @return
     */
    @Update({"update complaint set manager_id=#{manager.managerId},Complaint_settle=#{complaintSettle},Complaint_settledate=#{complaintSettledate} where Complaint_id=#{complaintId}"})
    @Options(useGeneratedKeys = true,keyColumn = "Complaint_id",keyProperty = "complaintId")
    public int updateOne(Complaint complaint);

}
