package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groupmealunit")
public class GroupMealUnit {

    /*  用餐单位编号  */
    @Id
    @Column(name = "GroupMealUnit_id")
    private Integer groupMealUnitId;

    /*   名称  */
    @Column(name = "GroupMealUnit_name")
    private String groupMealUnitName;

    /*  联系人  */
    @Column(name = "GroupMealUnit_contact")
    private String groupMealUnitContact;

    /*  联系方式（手机） */
    @Column(name = "GroupMealUnit_mobile")
    private String groupMealUnitMobile;

    /*  营业执照 */
    @Column(name = "GroupMealUnit_license")
    private String groupMealUnitLicense;

    /*  地址 */
    @Column(name = "GroupMealUnit_address")
    private String groupMealUnitAddress;

    /*  开户行 */
    @Column(name = "GroupMealUnit_bank")
    private String groupMealUnitBank;

    /*  开户账号 */
    @Column(name = "GroupMealUnit_account")
    private String groupMealUnitAccount;

    /*  状态(1：停用，1：启用) */
    @Column(name = "GroupMealUnit_status")
    private int groupMealUnitStatus;

    /*  办公电话  */
    @Column(name = "GroupMealUnit_officetel")
    private String groupMealUnitOfficetel;

    /*  公司简介  */
    @Column(name = "GroupMealUnit_disc")
    private String groupMealUnitDisc;

    /*  创建日期  */
    @Column(name = "GroupMealUnit_createDate")
    private Date groupMealUnitCreateDate;

    /*  审核日期 */
    @Column(name = "GroupMealUnit_reviewDate")
    private Date groupMealUnitReviewDate;

    /*  二维码  */
    @Column(name = "QR_Code")
    private String qrCode;

    /* ticker_id*/
    @Column(name = "GroupMealUnit_ticker_id")
    private String groupMealUnitTickerId;

}
