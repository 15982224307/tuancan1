package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 平台投诉 model
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Complaint  implements Serializable {

    @Id
    @Column(name = "Complaint_id")
    private Integer complaintId ;       // int not null auto_increment comment '投诉编号',

    private Manager manager;         //  int comment '管理员',  获取管理员id

    @Column(name = "Complainter")
    private String complainter ;         //varchar(256) comment '投诉人',

    @Column(name = "Complaint_content")
    private String complaintContent;    //varchar(1024) comment '投诉内容',

    @Column(name = "Complaint_date")
    private Date complaintDate;    //   timestamp comment '投诉日期',

    @Column(name = "Complaint_settle")
    private String complaintSettle;    // varchar(512) comment '处理结果',

    @Column(name = "Complaint_settledate")
    private Date complaintSettledate;  // timestamp comment '处理日期',
}
