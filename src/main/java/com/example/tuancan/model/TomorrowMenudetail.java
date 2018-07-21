package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TomorrowMenudetail implements Serializable{

    /**
     * 明日菜单明细编号
     */
    private Integer tomorrowMenuId;
    /**
     * 用餐单位,获取编号
     */
    private GroupMealUnit groupMealUnitId;
    /**
     * 明日菜单,获取编号
     */
    private TomorrowMenuMaster tomorrowMenuMasterId;
    /**
     * 是否推荐
     */
    private int tomorrowMenuIsRecommend;
    /**
     * 备注
     */
    private String tomorrowMenuMemo;

    
}
