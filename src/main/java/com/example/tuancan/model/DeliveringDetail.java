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

    private Integer deliveringMasterId;        //  int not null comment '配送单编号',
    private Integer recipeId;                //  int not null comment '食谱编号',
    private Integer deliveringDetailNo;          //  int comment '配送明细序号',
    private Integer deliveringDetailNumber;        // int comment '菜品数量',
    private String deliveringDetailMemo;      // varchar(256) comment '备注',
}
