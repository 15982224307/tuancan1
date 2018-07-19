package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 配送单
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveringMaster  implements Serializable {

    private Integer deliveringMaster_id;              //  int not null auto_increment comment '配送单编号',
    private  GroupMealUnit groupMealUnit_id ;                //  int comment '用餐单位，获取单位编号',
    private DeliveringCompany deliveringCompany_no ;             // int comment '团餐机构公司，获取编号',
    private Timestamp deliveringMaster_delivedate;        // timestamp comment '配送日期',
    private BigDecimal deliveringMaster_price ;            //decimal(8,2) comment '单价',
    private Integer deliveringMaster_amount;            // int comment '份数',
    private String deliveringMaster_memo ;              //varchar(256) comment '备注',
    private int deliveringMaster_status ;           //smallint comment '状态（0：新建，1：确认，2：已支付）',
    private int deliveringMaster_isEmergency;         //smallint comment '是否应急配送（0：不是，1：是）',
    private Timestamp deliveringMaster_createdate ;         //timestamp comment '创建日期',
    private String deliveringMaster_creater ;            //varchar(32) comment '创建人',
    private String deliveringMaster_confirmer;             // varchar(32) comment '确认人',
}
