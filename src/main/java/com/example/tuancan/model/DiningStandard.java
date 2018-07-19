package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 餐标
 */
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class DiningStandard  implements Serializable {

    private Integer standardId;            //  int not null auto_increment comment '餐标编号',
    private Integer deliveringCompany_no;       // int comment '公司编号',
    private String standardName;              //varchar(64) comment '名称',
    private int standardMeatnumber;          //  smallint comment '荤菜个数',
    private int standardVegetablenumber;       // smallint comment '素菜个数',
    private BigDecimal standardPrice;             //decimal(8,2) comment '单价',
    private int standardIsFreeSoup;            //  smallint comment '是否赠送汤菜(0:否，1：是)',
    private int standardIsFreeDessert ;          //smallint comment '是否赠送甜点(0:否，1：是)',
    private int standardIsFreeFruit ;         //smallint comment '是否赠送水果(0:否，1：是)',
    private Timestamp standardCreateDate ;               // timestamp comment '创建日期',
}
