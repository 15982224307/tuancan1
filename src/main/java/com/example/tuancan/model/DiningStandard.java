package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 餐标
 */
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "diningstandard")
public class DiningStandard  implements Serializable {

    /*餐标编号*/
    @Id
    @Column(name = "Standard_id")
    private Integer standardId;            //  int not null auto_increment comment '餐标编号',

    /*团餐公司 获取编号*/
    private DeliveringCompany deliveringCompany;       // int comment '团餐公司，获取编号',

    /*名称*/
    @Column(name = "Standard_name")
    private String standardName;              //varchar(64)

    /*荤菜个数*/
    @Column(name = "Standard_meatnumber")
    private int standardMeatnumber;          //  smallint

    /*素菜个数*/
    @Column(name = "Standard_Vegetablenumber")
    private int standardVegetablenumber;       // smallint

    /*单价*/
    @Column(name = "Standard_price")
    private BigDecimal standardPrice;             //decimal(8,2)  '

    /*是否赠送汤菜*/
    @Column(name = "Standard_IsFreeSoup")
    private int standardIsFreeSoup;            //  smallint (0:否，1：是)',

    /*是否赠送甜点*/
    @Column(name = "Standard_IsFreeDessert")
    private int standardIsFreeDessert ;          //smallint  '(0:否，1：是)',

    /*是否赠送水果*/
    @Column(name = "Standard_isFreeFruit")
    private int standardIsFreeFruit ;         //smallint comment '(0:否，1：是)',

    /*创建日期*/
    @Column(name = "Standard_CreateDate")
    private Date standardCreateDate ;               // timestamp
}
