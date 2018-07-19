package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GroupMealStaff {

    /*  用餐员工编号  */
    private Integer gMStaffId;

    /*  用餐单位编号  */
    private Integer groupMealUnitId;

    /*  手机号  */
    private String gMStafMobile;

    /*  姓名  */
    private String gMStaffName;

    /*  状态(0：停用，1：启用)  */
    private int gMStaffStatus;

    /*  性别  */
    private String gMStaffSex;

    /*  是否默认账号（0：不是,1：是）  */
    private int gMStafIsdefualt;

    /*  登录账号  */
    private String gMStafLoginname;

    /*  密码  */
    private String gMStafPassword;

    /*  Unit_ticker_id  */
    private String unitTickerId;

    /*  openId  */
    private String gMStaffOpenId;

    /*  创建日期  */
    private Date gMStafCreateDate;

}
