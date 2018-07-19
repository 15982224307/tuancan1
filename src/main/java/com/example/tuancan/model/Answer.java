package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 问答
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Answer implements Serializable{

    private Integer answerId ;          //ints not null auto_increment comment '回答编号',
    private int gMStaffId  ;         //int comment '用餐员工编号',
    private Integer questionnaireId;     //int comment '问卷编号',
    private String answerText  ;        //varchar(512) comment '回答',
    private Timestamp answerDate  ;        //timestamp comment '回答日期',

}
