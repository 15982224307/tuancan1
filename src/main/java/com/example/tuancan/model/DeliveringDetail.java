package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 配送明细
 */
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@Table(name = "delivering_detail")
public class DeliveringDetail implements Serializable {


    @Column(name = "DeliveringDetail_no")
    private String deliveringDetailNo;          //  int comment '配送明细序号',

    /*获取配送单编号*/
    private DeliveringMaster deliveringMaster;        //  int comment '配送单,',

    /*获取食谱编号*/
    private Recipe recipe;                //  int not null comment '食谱，  ',

    @Column(name = "DeliveringDetail_number")
    private Integer deliveringDetailNumber;        // int comment '菜品数量',

    @Column(name = "DeliveringDetail_memo")
    private String deliveringDetailMemo;      // varchar(256) comment '备注',
}
