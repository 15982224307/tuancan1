package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tomorrowmenudetail")
public class TomorrowMenudetail implements Serializable{

    /**
     * 明日菜单明细编号
     */
    @Id
    @Column(name = "TomorrowMenu_id")
    private Integer tomorrowMenuId;
    /**
     * 用餐单位,获取编号
     */
    private GroupMealUnit groupMealUnit;
    /**
     * 明日菜单,获取编号
     */
    private TomorrowMenuMaster tomorrowMenuMaster;
    /**
     * 是否推荐
     */
    @Column(name = "TomorrowMenu_id")
    private int tomorrowMenuIsRecommend;
    /**
     * 备注
     */
    @Column(name = "TomorrowMenu_id")
    private String tomorrowMenuMemo;

    
}
