package com.example.tuancan.model;

import com.example.tuancan.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 团餐机构
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deliveringcompany")
public class DeliveringCompany  implements Serializable {

    @Id
    @Column(name = "DeliveringCompany_no")
    private Integer deliveringCompanyNo;            //int not null auto_increment comment '公司编号',

    private CompanyGrade companyGrade;                 //int comment '等级'  用户获取等级编号,

    @Column(name = "DeliveringCompany_name")
    private String deliveringCompanyName;            //varchar(128) comment '公司名称',

    @Column(name = "DeliveringCompany_contact")
    private String deliveringCompanyContact;      // varchar(32) comment '公司联系人',

    @Column(name = "DeliveringCompany_Mobile")
    private String deliveringCompanyMobile;        // varchar(32) comment '联系方式（手机）',

    @Column(name = "DeliveringCompany_license")
    private String deliveringCompanyLicense ;         //varchar(128) comment '营业执照',

    @Column(name = "DeliveringCompany_address")
    private String deliveringCompanyAddress;              //varchar(128) comment '地址',

    @Column(name = "DeliveringCompany_status")
    private int deliveringCompanyStatus= StatusEnum.StatusUP.getCode();        // smallint comment '状态（0：停用，1：启用）',

    @Column(name = "DeliveringCompany_bank")
    private String deliveringCompanyBank;             // varchar(64) comment '开户行',

    @Column(name = "DeliveringCompany_account")
    private String deliveringCompanyAccount;          // varchar(32) comment '开户账号',

    @Column(name = "DeliveringCompany_disc")
    private String deliveringCompanyDisc;             // varchar(512) comment '公司简介',

    @Column(name = "DeliveringCompany_tel")
    private String deliveringCompanyTel ;             //varchar(32) comment '办公电话',

    @Column(name = "DeliveringCompany_createDate")
    private Date deliveringCompanyCreateDate;           // timestamp comment '创建日期',

    @Column(name = "DeliveringCompany_reviewDate")
    private Date deliveringCompanyReviewDate ;          //timestamp comment '审核日期',
}
