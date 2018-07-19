package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 配送明细
 */
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class DeliveringDetail implements Serializable {

    private DeliveringMaster deliveringMasterId;        //  int not null comment '配送单,获取配送单编号',
    private Recipe recipeId;                //  int not null comment '食谱，  获取食谱编号',
    private Integer deliveringDetailNo;          //  int comment '配送明细序号',
    private Integer deliveringDetailNumber;        // int comment '菜品数量',
    private String deliveringDetailMemo;      // varchar(256) comment '备注',
}
