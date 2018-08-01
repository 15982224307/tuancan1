package com.example.tuancan.dto;

import com.example.tuancan.model.Recipe;
import lombok.Data;

@Data
public class DeliverDetailVO {

    private String deliveringDetailNo;          //  int comment '配送明细序号',

    /*获取食谱编号*/
    private Recipe recipe=new Recipe();                //  int not null comment '食谱，  ',

    private Integer deliveringDetailNumber;        // int comment '菜品数量',

    private String deliveringDetailMemo;      // varchar(256) comment '备注',
}
