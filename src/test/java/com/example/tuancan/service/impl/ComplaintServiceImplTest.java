package com.example.tuancan.service.impl;

import com.example.tuancan.model.Complaint;
import com.example.tuancan.model.Manager;
import com.example.tuancan.service.ComplaintService;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplaintServiceImplTest {

    @Autowired
    private ComplaintService complaintService;

    @Test
    public void selectAllOrderByComplaintDate() throws Exception {
        Example example=new Example(Complaint.class);
        example.orderBy("complaintDate").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("complaintSettle",0);
        List<Complaint> complaints = complaintService.selectAllOrderByComplaintDate(example);
        System.out.println(JsonUtil.toJson(complaints));
    }

    @Test
    public void selectById() throws Exception {
        Complaint complaint = complaintService.selectById(1);
        System.out.println(complaint.getComplaintSettledate());
        System.out.println(JsonUtil.toJson(complaint));
    }

    @Test
    public void selectAllByManagerId() throws Exception {
        List<Complaint> complaints = complaintService.selectAllByManagerId(1);
        System.out.println(JsonUtil.toJson(complaints));
    }

    @Test
    public void selectAllBByComplaintSettleOrderBySettleDate() throws Exception {
        List<Complaint> complaints = complaintService.selectAllBByComplaintSettleOrderBySettleDate("0");
        System.out.println(JsonUtil.toJson(complaints));
    }

    @Test
    public void selectOneByIdWithManager() throws Exception {
        Complaint complaint = complaintService.selectOneByIdWithManager(1);
        System.out.println(JsonUtil.toJson(complaint));
    }

    @Test
    public void insertOne() throws Exception {
        Complaint complaint = new Complaint();
        Manager manager=new Manager();
        manager.setManagerId(1);
        complaint.setManager(manager);
        complaint.setComplaintContent("傻瓜");
        //complaint.setComplaintDate(new Date());
        complaint.setComplaintSettle("000");
        complaint.setComplainter("bbb");
        int i = complaintService.insertOne(complaint);
        System.out.println(JsonUtil.toJson(complaint));
    }

    @Test
    public void updateOne() throws Exception {
        Complaint complaint=new Complaint();
        complaint.setComplaintId(3);
        complaint.setComplaintSettle("1");
        complaint.setComplaintSettledate(new Date());
        Manager manager=new Manager();
        manager.setManagerId(1);
        complaint.setManager(manager);
        int i = complaintService.updateOne(complaint);
        System.out.println(i);
        System.out.println(JsonUtil.toJson(complaint));
    }

    @Test
    public void deleteOne() throws Exception {

        int i = complaintService.deleteOne(3);
        System.out.println(i);
    }

}