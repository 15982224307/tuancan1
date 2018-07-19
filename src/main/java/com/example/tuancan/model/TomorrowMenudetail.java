package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TomorrowMenudetail {

    /**
     * 明日菜单明细编号
     */
    private Integer tomorrowMenuId;
    /**
     * 用餐单位编号
     */
    private Integer groupMealUnitId;
    /**
     * 明日菜单编号
     */
    private Integer tomorrowMenuMasterId;
    /**
     * 是否推荐
     */
    private int tomorrowMenuIsRecommend;
    /**
     * 备注
     */
    private String tomorrowMenuMemo;

    
}
