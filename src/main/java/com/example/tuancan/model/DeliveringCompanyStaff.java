package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 团餐机构员工
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeliveringCompanyStaff  implements Serializable {

    private Integer dCompanyStaffId ;              // int not null auto_increment comment '团餐机构员工编号',
    private DeliveringCompany deliveringCompanyNo;            //int comment '公司,  获取公司编号',
    private String dCompanyStaffLoginname;           // varchar(32) comment '登录账号',
    private String dCompanyStaffPassword;         // varchar(32) comment '登录密码',
    private String dCompanyStaffMobile;           // varchar(11) comment '手机号',
    private String dCompanyStaffPosition;         // varchar(32) comment '职务',
    private int dCompanyStaffDefault;          // smallint comment '是否默认账号（0：不是，1：是）',
    private Integer dCompanyStaffAuthority;        // varchar(256) comment '权限',
    private int dCompanyStaffStatus;           // smallint comment '状态（0：停用，1：启用）',
    private Timestamp dCompanyStaffCreatedate;           // timestamp comment '创建日期',

}
