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
 *团餐菜单主表
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "groupmealmenumaster")
public class GroupMealMenumaster  implements Serializable {

    @Id
    @Column(name = "GroupMealMenumaster_id")
    private  Integer groupMealMenumasterId ;       //int not null auto_increment comment '团餐菜单编号',

    /*用餐单位,获取单位编号'*/
    private  GroupMealUnit groupMealUnit ;             // int comment '用餐单位,获取单位编号',

    /*名称*/
    @Column(name = "GroupMealMenumaster_name")
    private  String groupMealMenumasterName;        /// varchar(64) comment '名称',

    /*创建日期*/
    @Column(name = "GroupMealMenumaster_createdate")
    private Date groupMealMenumasterCreatedate;        // timestamp comment '创建日期',
}
