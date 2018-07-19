package com.example.tuancan.model;

public class Answer {
    private Integer Answer_id ;          //int not null auto_increment comment '回答编号',
    private int GMStaff_id  ;         //int comment '用餐员工编号',
    private Integer questionnaire_id;     //int comment '问卷编号',
    private Integer Answer_text  ;        //varchar(512) comment '回答',
    private Integer Answer_date  ;        //timestamp comment '回答日期',
}
