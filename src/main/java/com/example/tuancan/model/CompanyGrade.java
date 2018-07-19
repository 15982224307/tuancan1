package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 等级
 */

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompanyGrade  implements Serializable {

    private Integer companyGradeId ;     //int not null auto_increment comment '等级编号',
    private String companyGradeName ;   //varchar(64) comment '名称',
    private String companyGradeAuthority ;  //varchar(128) comment '功能',

}

