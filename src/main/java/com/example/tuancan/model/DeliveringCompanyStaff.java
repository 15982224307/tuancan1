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
 * 团餐机构员工
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deliveringcompanystaff")
public class DeliveringCompanyStaff  implements Serializable {

    @Id
    @Column(name = "DCompanyStaff_id")
    private Integer dCompanyStaffId ;              // int not null auto_increment comment '团餐机构员工编号',

    private DeliveringCompany deliveringCompany;            //int comment '公司,  获取公司编号',

    @Column(name = "DCompanyStaff_loginname")
    private String dCompanyStaffLoginname;           // varchar(32) comment '登录账号',

    @Column(name = "DCompanyStaff_password")
    private String dCompanyStaffPassword;         // varchar(32) comment '登录密码',

    @Column(name = "DCompanyStaff_mobile")
    private String dCompanyStaffMobile;           // varchar(11) comment '手机号',

    @Column(name = "DCompanyStaff_position")
    private String dCompanyStaffPosition;         // varchar(32) comment '职务',

    @Column(name = "DCompanyStaff_default")
    private int dCompanyStaffDefault= StatusEnum.NotDefaultAccount.getCode();// smallint comment '是否默认账号（0：不是，1：是）',

    @Column(name = "DCompanyStaff_authority")
    private String dCompanyStaffAuthority;        // varchar(256) comment '权限',

    @Column(name = "DCompanyStaff_status")
    private int dCompanyStaffStatus=StatusEnum.StatusUP.getCode();  // smallint comment '状态（0：停用，1：启用）',

    @Column(name = "DCompanyStaff_createdate")
    private Date dCompanyStaffCreatedate;           // timestamp comment '创建日期',

}
