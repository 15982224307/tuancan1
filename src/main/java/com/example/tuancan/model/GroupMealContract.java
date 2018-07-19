package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 团餐合同
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupMealContract  implements Serializable {

    private  Integer gMContractId;        //int not null auto_increment comment '合同编号',
    private  Integer standardId ;         //int comment '餐标编号',
    private  Integer groupMealUnitId;      //int comment '用餐单位编号',
    private  String gMlContractName;     //varchar(128) comment '合同名称',
    private  String gMlContractDisc;       //varchar(2048) comment '合同描述',
    private Timestamp gMlContractExpirydate;  // timestamp comment '合同有效期',
    private  int gMContractMeatnumber;     // smallint comment '配送荤菜个数',
    private  int gMlContractVegetablenumber;      // smallint comment '配送素菜个数',
    private  int gMlContractStatus;         ///smallint comment '合同状态',
    private  Timestamp gMContractSigndate ;    /// timestamp comment '签订日期',
    private  String gMlContractGroupA;     // varchar(32) comment '甲方签名',
    private  String gMContractGroupB;      //varchar(32) comment '乙方签名',
    private  Timestamp gMContractCreateDate ;     ///timestamp comment '创建日期',
}
