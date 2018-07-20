package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 问答
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answer")
public class Answer implements Serializable{

    @Id
    private Integer answerId ;          //ints not null auto_increment comment '回答编号',
    private GroupMealStaff gMStaffId  ;         //int comment '用餐员工', 用于获取用餐员工id
    private QuestionNaire questionnaireId;     //int comment '问卷', 用于获取问卷id
    private String answerText  ;        //varchar(512) comment '回答',
    private Timestamp answerDate  ;        //timestamp comment '回答日期',


}
