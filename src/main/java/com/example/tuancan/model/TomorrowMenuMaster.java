package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tomorrowmenumaster")
public class TomorrowMenuMaster implements Serializable{

    /**
     * 明日菜单编号
     */
    @Id
    @Column(name = "TomorrowMenuMaster_id")
    private Integer tomorrowMenuMasterId;
    /**
     *  用餐单位,获取编号
     */
    private GroupMealUnit groupMealUnit;
    /**
     *  使用日期
     */
    @Column(name = "TomorrowMenuMaster_usedate")
    private Date tomorrowMenuMasterUsedate;
    /**
     *  有效期
     */
    @Column(name = "TomorrowMenuMaster_expiredate")
    private Date tomorrowMenuMasterExpiredate;
    /**
     *  状态
     */
    @Column(name = "TomorrowMenuMaster_status")
    private int tomorrowMenuMasterStatus;
    /**
     *  备注
     */
    @Column(name = "TomorrowMenuMaster_memo")
    private String tomorrowMenuMasterMemo;
    /**
     *  创建日期
     */
    @Column(name = "TomorrowMenuMaster_createdate")
    private Date tomorrowMenuMasterCreatedate;


}
