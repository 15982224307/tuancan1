package com.example.tuancan.dao;

import com.example.tuancan.model.Complaint;
import com.example.tuancan.model.Manager;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ComplaintMapper extends Mapper<Complaint>{

    /**
     * 根据管理员id查询所有投诉
     * @param managerId
     * @return
     */
    @Select({"select * from complaint where manager_id=#{managerId}"})
    public List<Complaint> selectAllByManagerId(Integer managerId);

    @Select({"select * from complaint order by Complaint_date desc"})
    @ResultMap(value = "selectByManagerId")
    public List<Complaint> selectAll();

    @Select({"select * from complaint where manager_id is null"})
    @ResultMap(value = "selectByManagerId")
    public List<Complaint> selectNULL();
    /**
     * 根据id查询一条数据
     * @param complaintId
     * @return
     */
    @Select({"select * from complaint where Complaint_id=#{complaintId}"})
    @Results(id = "selectByManagerId",value = {
            @Result(column = "manager_id",property = "manager",javaType = Manager.class,
                    one=@One(select = "com.example.tuancan.dao.ManagerMapper.selectByPrimaryKey"))
    })
    public Complaint selectOneByIdWithManager(Integer complaintId);

    /**
     * 根据处理结果和投诉内容查询
     * @param complaintSettle
     * @return
     */
    @Select({"select * from complaint where Complaint_settle like '%${value}%' or Complaint_content like '%${value}%' order by Complaint_settledate desc"})
    public List<Complaint> selectAllBByComplaintSettleOrderBySettleDate(@Param("value") String complaintSettle);

    /**
     * 插入一条投诉数据
     * @param complaint
     * @return
     */
    @Insert({"insert into complaint(Complainter,Complaint_content,Complaint_settle) " +
            "values(#{complainter},#{complaintContent},#{complaintSettle})"})
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
