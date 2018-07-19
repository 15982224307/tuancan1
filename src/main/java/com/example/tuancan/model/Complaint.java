package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 平台投诉 model
 */

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Complaint  implements Serializable {

    private Integer complaintId ;       // int not null auto_increment comment '投诉编号',
    private Manager managerId;         //  int comment '管理员',  获取管理员id
    private String complainter ;         //varchar(256) comment '投诉人',
    private String complaintContent;    //varchar(1024) comment '投诉内容',
    private Timestamp complaintDate;    //   timestamp comment '投诉日期',
    private String complaintSettle;    // varchar(512) comment '处理结果',
    private Timestamp complaintSettledate;  // timestamp comment '处理日期',
}
