package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 团餐机构
 */

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveringCompany  implements Serializable {

    private Integer deliveringCompanyNo;            //int not null auto_increment comment '公司编号',
    private CompanyGrade companyGradeId;                 //int comment '等级'  用户获取等级编号,
    private String deliveringCompanyName;            //varchar(128) comment '公司名称',
    private String deliveringCompanyContact;      // varchar(32) comment '公司联系人',
    private String deliveringCompanyMobile;        // varchar(32) comment '联系方式（手机）',
    private String deliveringCompanyLicense ;         //varchar(128) comment '营业执照',
    private String deliveringCompanyAddress;              //varchar(128) comment '地址',
    private int deliveringCompanyStatus;              // smallint comment '状态（0：停用，1：启用）',
    private String deliveringCompanyBank;             // varchar(64) comment '开户行',
    private String deliveringCompanyAccount;          // varchar(32) comment '开户账号',
    private String deliveringCompanyDisc;             // varchar(512) comment '公司简介',
    private String deliveringCompanyTel ;             //varchar(32) comment '办公电话',
    private Timestamp deliveringCompanyCreateDate;           // timestamp comment '创建日期',
    private Timestamp deliveringCompanyReviewDate ;          //timestamp comment '审核日期',
}
