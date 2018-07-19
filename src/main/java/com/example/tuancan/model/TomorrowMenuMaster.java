package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TomorrowMenuMaster {

    /**
     * 明日菜单编号
     */
    private Integer tomorrowMenuMasterId;
    /**
     *  用餐单位编号
     */
    private Integer troupMealUnitId;
    /**
     *  使用日期
     */
    private Date tomorrowMenuMasterUsedate;
    /**
     *  有效期
     */
    private Date tomorrowMenuMasterExpiredate;
    /**
     *  状态
     */
    private int tomorrowMenuMasterStatus;
    /**
     *  备注
     */
    private String tomorrowMenuMasterMemo;
    /**
     *  创建日期
     */
    private Date tomorrowMenuMasterCreatedate;


}
