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
 * 配送单
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deliveringmaster")
public class DeliveringMaster  implements Serializable {

    @Id
    @Column(name = "DeliveringMaster_id")
    private Integer deliveringMaster_id;              //  int not null auto_increment comment '配送单编号',

    private GroupMealUnit groupMealUnit;          //  int comment '用餐单位，获取单位编号',

    private DeliveringCompany deliveringCompany;      // int comment '团餐机构公司，获取编号',

    @Column(name ="DeliveringMaster_delivedate")
    private Date deliveringMaster_delivedate;        // timestamp comment '配送日期',

    @Column(name = "DeliveringMaster_price")
    private BigDecimal deliveringMaster_price ;            //decimal(8,2) comment '单价',

    @Column(name = "DeliveringMaster_amount")
    private Integer deliveringMaster_amount;            // int comment '份数',

    @Column(name = "DeliveringMaster_memo")
    private String deliveringMaster_memo ;              //varchar(256) comment '备注',

    @Column(name = "DeliveringMaster_status")
    private int deliveringMaster_status ;           //smallint comment '状态（0：新建，1：确认，2：已支付）',

    @Column(name = "DeliveringMaster_isEmergency")
    private int deliveringMaster_isEmergency;         //smallint comment '是否应急配送（0：不是，1：是）',

    @Column(name = "DeliveringMaster_createdate")
    private Date deliveringMaster_createdate ;         //timestamp comment '创建日期',

    @Column(name = "DeliveringMaster_creater")
    private String deliveringMaster_creater ;            //varchar(32) comment '创建人',

    @Column(name = "DeliveringMaster_confirmer")
    private String deliveringMaster_confirmer;             // varchar(32) comment '确认人',
}
