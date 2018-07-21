package com.example.tuancan.model;

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
 * 团餐合同
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name = "groupmealcontract")
public class GroupMealContract  implements Serializable {

    /*合同编号*/
    @Id
    @Column(name = "GMContract_id")
    private  Integer gMContractId;        //int not null auto_increment  ,

    /*获取餐标编号*/
    private  DiningStandard standard ;         //int comment '餐标,获取餐标编号',

    /*获取单位编号*/
    private  GroupMealUnit groupMealUnit;      //int comment '用餐单位,',

    /*合同名称*/
    @Column(name = "GMlContract_name")
    private  String gMlContractName;     //varchar(128)

    /*合同描述*/
    @Column(name = "GMlContract_disc")
    private  String gMlContractDisc;       //varchar(2048)

    /*合同有效期*/
    @Column(name = "GMlContract_expirydate")
    private Date gMlContractExpirydate;  // timestamp

    /*配送荤菜个数*/
    @Column(name = "GMContract_meatnumber")
    private  int gMContractMeatnumber;     // smallint

    /*配送素菜个数*/
    @Column(name = "GMlContract_vegetablenumber")
    private  int gMlContractVegetablenumber;      // smallint

    /*合同状态*/
    @Column(name = "GMlContract_status")
    private  int gMlContractStatus;         ///smallint comment '',

    /*签订日期*/
    @Column(name = "GMContract_signdate")
    private  Date gMContractSigndate ;    /// timestamp comment '签订日期',

    /*甲方签名*/
    @Column(name = "GMlContract_GroupA")
    private  String gMlContractGroupA;     // varchar(32) comment '',

    /*乙方签名*/
    @Column(name = "GMContract_GroupB")
    private  String gMContractGroupB;      //varchar(32) comment '乙方签名',

    /*创建日期*/
    @Column(name = "GMContract_createDate")
    private Date gMContractCreateDate ;     ///timestamp comment '',
}
