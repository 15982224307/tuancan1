package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 *团餐菜单主表
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GroupMealMenumaster  implements Serializable {

    private  Integer groupMealMenumasterId ;       //int not null auto_increment comment '团餐菜单编号',
    private  GroupMealUnit groupMealUnitId ;             // int comment '用餐单位,获取单位编号',
    private  String groupMealMenumasterName;        /// varchar(64) comment '名称',
    private Date groupMealMenumasterCreatedate;        // timestamp comment '创建日期',
}