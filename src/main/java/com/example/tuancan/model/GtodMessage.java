package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gtodmessage")
public class GtodMessage {

    /*消息编号*/
    @Id
    @Column(name = "gtodmessage_id")
    private Integer gtodmessageId;

    /*消息状态（0：新建，1：已读）*/
    @Column(name = "gtodmessage_status")
    private int gtodmessageStatus;

    /*消息内容*/
    @Column(name = "gtodmessage_content")
    private String gtodmessageContent;

    /*发起人编号（用餐企业）*/
    @Column(name = "gtodmessage_sender")
    private Integer gtodmessageSender;

    /*处理人编号（团餐机构）*/
    @Column(name = "gtodmessage_receiver")
    private Integer gtodmessageReceiver;

    /*消息创建日期*/
    @Column(name = "gtodmessage_createdate")
    private Date gtodmessagereatedate;
}
