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

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groupmealstaff")
public class GroupMealStaff implements Serializable{

    /*  用餐员工编号  Unknown column 'g_m_staff_id' in 'field list'*/
    @Id
    @Column(name = "GMStaff_id")
    private Integer gMStaffId;

    /*  用餐单位,获取编号  */
    //  @Column(name = "GroupMealUnit_id")
    private GroupMealUnit groupMealUnitId;

    /*  手机号  */
    @Column(name = "GMStaf_Mobile")
    private String gMStafMobile;

    /*  姓名  */
    @Column(name = "GMStaff_name")
    private String gMStaffName;

    /*  状态(0：停用，1：启用)  */
    @Column(name = "GMStaff_status")
    private int gMStaffStatus= StatusEnum.StatusUP.getCode();

    /*  性别  */
    @Column(name = "GMStaff_sex")
    private String gMStaffSex;

    /*  是否默认账号（0：不是,1：是）  */
    @Column(name = "GMStaf_isdefualt")
    private int gMStafIsdefualt=StatusEnum.NotDefaultAccount.getCode();

    /*  登录账号  */
    @Column(name = "GMStaf_loginname")
    private String gMStafLoginname;

    /*  密码  */
    @Column(name = "GMStaf_password")
    private String gMStafPassword;

    /*  Unit_ticker_id  */
    @Column(name = "Unit_ticker_id")
    private String unitTickerId;

    /*  openId  */
    @Column(name = "GMStaff_OpenId")
    private String gMStaffOpenId;

    /*  创建日期  */
    @Column(name = "GMStaf_createDate")
    private Date gMStafCreateDate;

}
