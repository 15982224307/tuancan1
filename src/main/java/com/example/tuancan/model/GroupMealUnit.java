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
public class GroupMealUnit {
    /*  用餐单位编号  */
    private Integer groupMealUnitId;

    /*   名称  */
    private String groupMealUnitName;

    /*  联系人  */
    private String groupMealUnitContact;

    /*  联系方式（手机） */
    private String groupMealUnitMobile;

    /*  营业执照 */
    private String groupMealUnitLicense;

    /*  地址 */
    private String groupMealUnitAddress;

    /*  开户行 */
    private String groupMealUnitBank;

    /*  开户账号 */
    private String groupMealUnitAccount;

    /*  状态(1：停用，1：启用) */
    private int groupMealUnitStatus;

    /*  办公电话  */
    private String groupMealUnitOfficetel;

    /*  公司简介  */
    private String groupMealUnitDisc;

    /*  创建日期  */
    private Date groupMealUnitCreateDate;

    /*  审核日期 */
    private Date groupMealUnitReviewDate;

    /*  二维码  */
    private String qrCode;

    /* ticker_id*/
    private String groupMealUnitTickerId;

}
